var app = angular.module("app", []);

app.factory('ClientApiService',['$http','$q',function($http,$q){
	
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded;charset=utf-8";
	var param = function(obj) {
	var query = "", name, value, fullSubName, subName, subValue, innerObj, i;
	for (name in obj) {
		value = obj[name];
		if (value instanceof Array) {
		for (i = 0; i < value.length; ++i) {
			subValue = value[i];
			fullSubName = name + "[" + i + "]";
			innerObj = {};
			innerObj[fullSubName] = subValue;
			query += param(innerObj) + "&";
			}
		} else if (value instanceof Object) {
			for (subName in value) {
				subValue = value[subName];
				fullSubName = name + "[" + subName + "]";
				innerObj = {};
				innerObj[fullSubName] = subValue;
				query += param(innerObj) + "&";
			}
		} else if (value !== undefined && value !== null) {
			query += encodeURIComponent(name) + "=" + encodeURIComponent(value) + "&";
		}
	}
	return query.length ? query.substr(0, query.length - 1): query;
	};
	$http.defaults.transformRequest = [ function(data) {
		return angular.isObject(data)&& String(data) !== "[object File]" ? param(data): data;
	} ];
	return {
		list:function(page,count){
			var deferred = $q.defer();
			$http.post('/admin/client/api/list/ajax',{
				'p':page,
				'ps':20
			}).success(function(result) {
				if (result!=null && result.code == 200) {
					deferred.resolve(result.clientApis); 
				} else {
					deferred.reject(result.msg);
				}
			}).error(function() {
				deferred.reject('内部错误');
			});
			return deferred.promise;
		},
		remove:function(clientApi){
			var deferred = $q.defer();
			$http.post('/admin/api/del', clientApi).success(function(result){
				if(result.code == 200){
					deferred.resolve();
				}else{
					deferred.reject(result.msg);
				}
			}).error(function(){
				deferred.reject('内部错误');
			});
			return deferred.promise;
		},
		getClientApiInfo:function(id){
			return $http.post('/admin/api/detail/'+id);
		},
		modify:function(clientApi){
			//delete schedule["createTime"];
			return $http.post('/admin/api/edit', clientApi);
		}
	}
}]);

app.controller('clientApiCtrl',function($scope, $sce, ClientApiService) {
	$scope.page = page - 1;
	var ps = 20;
	var loadClientApis = function(){
		ClientApiService.list($scope.page,ps)
		.then(function(result) {
			for(var i=0;i<result.length;i++){
				var obj = result[i];
				var timeStr = obj.apiUpdateTime;
				var time = Date.parse(timeStr);
				var now = new Date().getTime();
				if(now - time < 1000*3600*24*3) {
					// new modified api
					obj.apiUpdateTime = $sce.trustAsHtml('<b>' + obj.apiUpdateTime + '</b> (new<font color="red" size="6">&#9996;</font>)');
				} else {
					obj.apiUpdateTime = $sce.trustAsHtml('<font color="gray">' + obj.apiUpdateTime + '</font>');
				}
				$scope.clientApis.push(obj);
			}
		},function(msg) {
			alert(msg);
		});
	}
	
	loadClientApis();
	
	$scope.clientApi = {
		apiId : '',
		apiSection : '',
		apiName : '',
		apiDesc : '',
		apiIsPost : '',
		apiUrl : '',
		apiUpdateTime: ''
	};
	$scope.clientApis=[];
	
	$scope.add = function() {
		ClientApiService.add($scope.clientApi)
		.then(function(result) {
			$scope.clear();
			$scope.clientApis.splice(0,0,result);
		},function(msg) {
			alert(msg);
		});

	}
	$scope.list = function(){
		loadClientApis();
	};
	
	$scope.clear = function() {
		$scope.clientApi.apiId = '';
		$scope.clientApi.apiSection = '';
		$scope.clientApi.apiName = '';
		$scope.clientApi.apiDesc = '';
		$scope.clientApi.apiIsPost = '';
		$scope.clientApi.apiUrl = '';
		$scope.clientApi.apiUpdateTime = '';
	};
	/**
	 * 删除渠道
	 */
	$scope['delete']=function(index){
		var clientApi = $scope.clientApis[index];
		ClientApiService.remove(clientApi).then(function(){
			$scope.clientApis.splice(index,1);
		},function(msg){
			alert(msg);
		});
		
	}
});

app.directive('clientApi',function(){
	return {
		restrict:"A",
		link:function(scope,element,attrs){
			scope.id =element.attr("data-id");
		}
	}
});
app.controller('EditController',function($scope,$timeout,ClientApiService){
	$scope.id = -1;
	$scope.clientApi={
		
	};
	var loadInfo=function(){
		$timeout(function(){
			if($scope.id!=-1){
				ClientApiService.getClientApiInfo($scope.apiId).success(function(result){
					$scope.clientApi = result.clientApi;
				});
			}else{
				loadInfo();
			}
		},100);
	}
	loadInfo();
	
	$scope.modify = function(){
		ClientApiService.modify($scope.clientApi, $scope.apiId).success(function(result){
			alert(result.msg);
		});
	}
});

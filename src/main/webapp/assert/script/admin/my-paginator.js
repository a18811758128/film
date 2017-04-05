 /**
 * my simple paginator
 */

;(function($, window, document, undefined) {

  var name = "myPaginator",
      instance = null,
      defaults = {
        pageBase: 1,
        firstPage: 1,
        lastPage: 10,
        curPage: 1,
        startRange: 2,
        midRange: 5,
        endRange: 2,
        previous: "← previous",
        next: "next →",
        minHeight: true,
        callback: undefined // function( pages, items ) { }
      };

  function Plugin(element, options) {
    this.options = $.extend({}, defaults, options);
    this._container = $(element);

    this.jQwindow = $(window);
    this.jQdocument = $(document);

    this._first = this.options.firstPage;
    this._previous = this.options.previous;
    this._next = this.options.next;
    this._last = this.options.lastPage;
    this._currentPageNum = this.options.curPage;
    this._nav = {};

    this.init();
  }

  Plugin.prototype = {

    constructor : Plugin,

    init : function() {
      this.setStyles();
      this.initPageIndex();
      this.initPageEvents();
      this.initNav();
      this.paginate(this._currentPageNum);
      this.setMinHeight();
    },

    setStyles : function() {
      var requiredStyles = "<style>"
        + ".page-index, .prev-page, .next-page { "
        +   "display: inline-block; "
        +   "cursor: pointer; "
        +   "margin:3px; "
        +   "padding-left: 3px; "
        +   "padding-right: 3px;"
        +   "color: #777;"
        + "} "
        + ".page-index:hover {"
        +   "background: #ccc;"
        + "} "
        + ".cur-page-index { "
        +   "border: 1px solid #eee; "
        +   "color: white; "
        +   "background: #ccc; "
        + "}"
        + ".disabled {"
        +   "color: #bbb;"
        +   "cursor: default;"
        + "}"
        + ".hidden {"
        +   "display: none !important;"
        + "}"
        + "</style>";

      $(requiredStyles).appendTo("head");
    },

    initPageIndex : function() {
      var html = '<span class="prev-page">' + this._previous + '</span>';
      for (var i = this._first; i <= this._last; i++) {
        if (i == this._currentPageNum) {
          html += '<span class="page-index cur-page-index" value="' + i + '">' + i + '</span>';
        } else {
          html += '<span class="page-index" value="' + i + '">' + i + '</span>';
        }
      }
      html += '<span class="next-page">' + this._next + '</span>';
      this._container.html(html);
    },

    initPageEvents : function() {
      $(".page-index").unbind("click");
      var that = this;
      $(".page-index").bind("click", function(){
        if ($(this).hasClass("cur-page-index")) {
          return;
        }
        var newPage = $(this).attr("value");
        that.paginate(newPage)
      });
      $(".prev-page").bind("click", function(){
        var newPage = that._currentPageNum - 1;
        that.paginate(newPage);
      });
      $(".next-page").bind("click", function(){
        var newPage = that._currentPageNum + 1;
        that.paginate(newPage);
      });
    },

    initNav : function() {
      var navArr = $(".page-index").toArray();
      for (var i = 0; i < navArr.length; i++) {
        var nav = $(navArr[i]);
        this._nav[nav.attr("value")] = nav;
      }
    },

    paginate : function(page) {
      if (page < this._first || page > this._last) {
        return;
      }
      this._currentPageNum = parseInt(page);
      this.updateStyle();
      this.callback();
      if (this.options.startRange + this.options.midRange
          + this.options.endRange >= this._last) {
        return;
      }
      this.updateRanges();
    },

    updateRanges : function() {
      $(".page-index").addClass("hidden");
      for (var i = this._first; i <= this.options.startRange; i++) {
        var nav = this._nav[i];
        nav.removeClass("hidden");
      }
      for (var i = this._last; i > this._last - this.options.endRange; i--) {
        var nav = this._nav[i];
        nav.removeClass("hidden");
      }
      var midStart = Math.round((this._first + this._last - this.options.midRange) / 2);
      for (var i = midStart; i < midStart + this.options.midRange; i++) {
        var nav = this._nav[i];
        nav.removeClass("hidden");
      }
      var curRangeStart = this._currentPageNum - 2;
      if (curRangeStart < this._first) {
        curRangeStart = this._first;
      }
      var curRangeEnd = this._currentPageNum + 2;
      if (curRangeEnd > this._last) {
        curRangeEnd = this._last;
      }
      for (var i = curRangeStart; i <= curRangeEnd; i++) {
        var nav = this._nav[i];
        nav.removeClass("hidden");
      }
      this.updateRangeGaps();
    },

    updateRangeGaps : function() {
      $(".range-gap").remove();
      var hiddenFlag = false;
      for (var i = this._first; i <= this._last; i++) {
        var nav = this._nav[i];
        if (nav.hasClass("hidden")) {
          hiddenFlag = true;
        } else if (hiddenFlag) {
          nav.before("<span class='range-gap'>...</span>");
          hiddenFlag = false;
        }
      }
    },

    updateStyle : function() {
      if (this._currentPageNum == this._first) {
        $(".prev-page").addClass("disabled");
      } else {
        $(".prev-page").removeClass("disabled");
      }
      if (this._currentPageNum == this._last) {
        $(".next-page").addClass("disabled");
      } else {
        $(".next-page").removeClass("disabled");
      }
      $(".cur-page-index").removeClass("cur-page-index");
      $(".page-index[value="+this._currentPageNum+"]").addClass('cur-page-index');
    },

    callback : function() {
      if ($.isFunction(this.options.callback)) {
        this.options.callback(this._currentPageNum - this.options.pageBase);
      }
    },

    setMinHeight : function() {
      if (this.options.minHeight && !this._container.is("table, tbody")) {
        setTimeout(this.bind(function() {
          this._container.css({ "min-height": this._container.css("height") });
        }, this), 1000);
      }
    },

    bind : function(fn, me) {
      return function() {
        return fn.apply(me, arguments);
      };
    },

  };

  $.fn[name] = function(arg) {
    var type = $.type(arg);

    if (type === "object") {
      if (this.length && !$.data(this, name)) {
        instance = new Plugin(this, arg);
        this.each(function() {
          $.data(this, name, instance);
        });
      }
      return this;
    }
    return this;
  };

})(jQuery, window, document);

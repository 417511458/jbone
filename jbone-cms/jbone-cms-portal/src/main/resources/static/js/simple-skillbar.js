/*!jQuery Simple SkillBar*/

/**
 *  Version: 1.0.0 (06/11/2016)
 *  Copyright (c) 2016 Leonhard Sinaga
 *  Under MIT and GPL licenses:
 *  http://www.opensource.org/licenses/mit-license.php
 *  http://www.gnu.org/licenses/gpl.html
 *  Source: https://github.com/leonhards/jquery-simple-skillbar
 */

(function ( $ ) {

    "use strict";

    var sb = {};

    sb.o = function() {
        this.o = null;
        this.$ = null;

        this.run = function() {
            this.o = $.extend(
                {
                    width: this.$.data('width') || 80,
                    height: this.$.data('height') || 30,
                    textColor: this.$.data('text-color') || '#ffffff',
                    background: this.$.data('background') || '#337ab7'
                }, this.o
            );

            this.class(this.$);
            this.intv(this.$);
          
            return this;
        };
    };

    sb.cb = function() {
        sb.o.call(this);

        this.class = function(i) {
            i.addClass("sb_progress");
            i.html("<div class='sb_bar'><div class='sb_label'>"+i.text()+"</div></div>");
            i.css({
                position: 'relative',
                width: '100%',
                backgroundColor: '#dddddd',
                height: this.o.height+'px'
            });
            i.find('.sb_bar').css({
                position: 'absolute',
                width: '1%',
                height: '100%',
                backgroundColor: this.o.background
            });
            i.find('.sb_label').css({
                paddingLeft: '5px',
                lineHeight: this.o.height+'px',
                color: this.o.textColor
            });
        };

        this.intv = function(i) {
            var s = this;
            var e = i.find('.sb_bar');
            var w = 1;
            var t = setInterval( function() { itv(); }, 10 );            

            var itv = function() {
                if ( w >= s.o.width ) {
                    clearInterval(t);
                } else {
                    w++;
                    e.css('width', w+'%');
                }
            };
        };
    };

    $.fn.simpleSkillbar = function(o) {

        return this.each(function() {
            var d = new sb.cb();
            d.o = o;
            d.$ = $(this);
            d.run();
        });
    };
 
}( jQuery ));
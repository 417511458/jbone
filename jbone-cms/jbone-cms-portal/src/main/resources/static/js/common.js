$(document).ready(function() {
    // $("[yne-bulb-block='code'] pre").addClass("prettyprint linenums");
    document.querySelectorAll('pre code').forEach((block) => {
        hljs.highlightBlock(block);
    });
});
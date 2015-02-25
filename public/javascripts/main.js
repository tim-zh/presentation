var markDiv;
var setMark = function(x1, y1, x2, y2) {
  if (!markDiv) {
    markDiv = document.createElement("div");
    document.body.appendChild(markDiv);
    markDiv.style.position = "absolute";
    markDiv.style.zIndex = 100;
  }
  markDiv.style.border = "#f55f5f solid 2px";
  markDiv.style.left = x1 + "px";
  markDiv.style.top = y1 + "px";
  markDiv.style.width = (x2 - x1) + "px";
  markDiv.style.height = (y2 - y1) + "px";
};
var clearMark = function() {
  markDiv.style.border = "transparent";
};
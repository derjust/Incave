 function openWindowWidthHeight(URL, windowWidth, windowHeight) {
	var windowLeft=(screen.availWidth/2)-(windowWidth/2);
	var windowTop=(screen.availHeight/2)-(windowHeight/2);
	window.open(URL,"","toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,"+
			"width="+windowWidth+",height="+windowHeight+",left="+windowLeft+",top="+windowTop);
}

function openWindowByURL(URL){
	var windowWidth=875;
	var windowHeight=650;
	openWindowWidthHeight(URL, windowWidth, windowHeight);
}

function openGallery( gid ) {
    link = "picsnvids_gallery.jsp?gid="+gid;
    openWindowByURL( link );
}
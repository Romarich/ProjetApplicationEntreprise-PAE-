if(document.cookie == ""){
document.cookie = "page=" + "oui";
$.ajax({
		method: "GET",
		url: "/client",
		success: function(texte){
			$('body').append(texte);
		} 
	});
}

/*window.onbeforeunload = function(e) {
    document.cookie = 'page=; expires=' + e.toGMTString() + ';';
};
!!! comment on fait si le gars refresh la page ? !!!
*/

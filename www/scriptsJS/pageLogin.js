if(getCookie("token") != ""){
	$.ajax({
		method: "POST",
		url: "/client",
		data:  { action: "verif",jwt:document.cookie},
		success: function(texte){
			$(".divGene").filter(function() { return $(this).css("display") == "block" }).css("display","none");
			$('#bodyEtudiant').css("display","block");
			console.log("parfait");
		},
		statusCode: {
	        400: function(texte) {
	      		$(".divGene").filter(function() { return $(this).css("display") == "block" }).css("display","none");
	        	$('#bodyConnexion').css("display","block");
	        	console.log("error");
	      }
	      
	   }
	});
}

$("#connexion").click(function(){
	if($("#pseudo").val() == "" && $("#erreurPseudo").length == 0){
		$("#pseudo").css("border-color", "red");
		$("#pseudo").last().after('<p class="text-danger" id="erreurPseudo">Veuillez renseigner votre pseudo</p>');
	}else if($("#pseudo").val() != "" && $("#erreurPseudo").length > 0){
        $("#pseudo").css("border-color", "rgb(110, 112, 126)");
        $("#erreurPseudo").remove();
    }
	if($("#motDePasse").val() == "" && $("#erreurMdp").length == 0){
		$("#motDePasse").css("border-color", "red");
		$("#motDePasse").last().after('<p class="text-danger" id="erreurMdp">Veuillez renseigner votre mot de passe</p>');
	}else if($("#motDePasse").val() != "" && $("#erreurMdp").length > 0){
        $("#motDePasse").css("border-color", "rgb(110, 112, 126)");
        $("#erreurMdp").remove();
    }
	
	if(verifErreur()){
		let jason = "{\"pseudo\":\"" + $("#pseudo").val()+ "\",\"mdp\":\"" + $("#motDePasse").val() +"\"}";
		$.ajax({
			method: "POST",
			url: "/client",
			data:  { action: "connexion",json:jason},
			success: function(texte){
				$('#bodyConnexion').css("display","none");
				$('#bodyBarreDeNavigationEtudiant').css("display","block");
				$('#bodyEtudiant').css("display","block");
				document.cookie = "token="+ texte;
			},
			statusCode: {
                400: function(texte) {
                	$("#vousEtesBienInscrit").remove();
                	$("#soucisBizz").remove();
                    if($("#soucisBizz").length == 0){
                	    $('#message').append('<p class="bg-danger" id="soucisBizz">' + texte.responseText + '</p>');
                        $("#soucisBizz").css("color", "white");
                    }else if($("#soucisBizz").length >0 && texte.responseText != $("#soucisBizz").val()){
                        $("#soucisBizz").remove();
                        $('#message').append('<p class="bg-danger" id="soucisBizz">' + texte.responseText + '</p>');
                        $("#soucisBizz").css("color", "white");
                    }
                }
            }
		});	
	}
});

$("#inscription").click(function(){
	$('#bodyConnexion').css("display","none");
    $('#bodyInscription').css("display","block");
    $("#soucisBizz").remove();
    for(var i=0; i<$('.form-control').length;i++){
    	$('.form-control').get(i).value = "";
    	//$('.form-control').get(i).css("border-color", "rgb(110, 112, 126)");
    	$("#pseudoInscr").css("border-color", "rgb(110, 112, 126)");
		$("#erreurPseudoInscr").remove();
		$("#nom").css("border-color", "rgb(110, 112, 126)");
		$("#erreurNom").remove();
		$("#prenom").css("border-color", "rgb(110, 112, 126)");
		$("#erreurPrenom").remove();
		$("#email").css("border-color", "rgb(110, 112, 126)");
		$("#erreurEmail").remove();
		$("#motDePasseInscr").css("border-color", "rgb(110, 112, 126)");
		$("#erreurMdpInscr").remove();
		$("#confirmationMdp").css("border-color", "rgb(110, 112, 126)");
			$("#erreurConfirmMdp").remove();
			$("#erreurConfirmMdpPasMeme").remove();
    }
});

function verifErreur(){
	if($("#pseudo").val() != "" && $("#motDePasse").val() != "") return true;
	return false;
}

$("#senregistrer").click(function () {
    if ($("#pseudoInscr").val() == "" && $("#erreurPseudoInscr").length == 0) {
        $("#pseudoInscr").css("border-color", "red");
        $("#pseudoInscr").last().after('<p class="text-danger" id="erreurPseudoInscr">Veuillez renseigner votre pseudo</p>');
    }else if($("#pseudoInscr").val() != "" && $("#erreurPseudoInscr").length > 0){
        $("#pseudoInscr").css("border-color", "rgb(110, 112, 126)");
        $("#erreurPseudoInscr").remove();
    }
    if ($("#nom").val() == "" && $("#erreurNom").length == 0) {
        $("#nom").css("border-color", "red");
        $("#nom").last().after('<p class="text-danger" id="erreurNom">Veuillez renseigner votre nom</p>');
    }else if($("#nom").val() != "" && $("#erreurNom").length > 0){
        $("#nom").css("border-color", "rgb(110, 112, 126)");
        $("#erreurNom").remove();
    }
    if ($("#prenom").val() == "" && $("#erreurPrenom").length == 0) {
        $("#prenom").css("border-color", "red");
        $("#prenom").last().after('<p class="text-danger" id="erreurPrenom">Veuillez renseigner votre prenom</p>');
    }else if($("#prenom").val() != "" && $("#erreurPrenom").length > 0){
        $("#prenom").css("border-color", "rgb(110, 112, 126)");
        $("#erreurPrenom").remove();
    }
    var email = new RegExp('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$');
    if (($("#email").val() == "" && $("#erreurEmail").length == 0)) {
        $("#email").css("border-color", "red");
        $("#email").last().after('<p class="text-danger" id="erreurEmail">Veuillez renseigner votre email</p>');
    } else if (!email.test($("#email").val()) && $("#erreurEmail").length == 0) {
        $("#email").css("border-color", "red");
        $("#email").last().after('<p class="text-danger" id="erreurEmail">Veuillez rentrer une adresse mail valide</p>');
    }else if(email.test($("#email").val()) && $("#erreurEmail").length >0){
        $("#email").css("border-color", "rgb(110, 112, 126)");
        $("#erreurEmail").remove();
    }
    if ($("#motDePasseInscr").val() == "" && $("#erreurMdpInscr").length == 0) {
        $("#motDePasseInscr").css("border-color", "red");
        $("#motDePasseInscr").last().after('<p class="text-danger" id="erreurMdpInscr">Veuillez renseigner votre mot de passe</p>');
    }else if($("#motDePasseInscr").val() != "" && $("#erreurMdpInscr").length > 0){
        $("#motDePasseInscr").css("border-color", "rgb(110, 112, 126)");
        $("#erreurMdpInscr").remove();
    }
    if ($("#confirmationMdp").val() == "" && $("#erreurConfirmMdp").length == 0) {
        $("#confirmationMdp").css("border-color", "red");
        $("#confirmationMdp").last().after('<p class="text-danger" id="erreurConfirmMdp">Veuillez renseigner la confirmation du mot de passe</p>');
    }else if($("#confirmationMdp").val() != "" && $("#erreurConfirmMdp").length > 0){
        $("#confirmationMdp").css("border-color", "rgb(110, 112, 126)");
        $("#erreurConfirmMdp").remove();
    }
    if ($("#confirmationMdp").val() != $("#motDePasseInscr").val() && $("#erreurConfirmMdpPasMeme").length == 0) {
        $("#confirmationMdp").css("border-color", "red");
        $("#confirmationMdp").last().after('<p class="text-danger" id="erreurConfirmMdpPasMeme">La confirmation du mot de passe doit être la même que le mot de passe</p>');
    }else if($("#confirmationMdp").val() == $("#motDePasseInscr").val() && $("#erreurConfirmMdpPasMeme").length > 0){
        $("#confirmationMdp").css("border-color", "rgb(110, 112, 126)");
        $("#erreurConfirmMdpPasMeme").remove();
    }
    if (verifErreurInscr()) {
        var jason = "{\"pseudo\":\"" + $("#pseudoInscr").val() + "\",\"nom\":\""
        + $("#nom").val() + "\",\"prenom\":\"" + $("#prenom").val() + "\",\"email\":\"" + $("#email").val() + "\",\"motDePasse\":\""
        + $("#motDePasseInscr").val() + "\",\"confirmationMdp\":\"" + $("#confirmationMdp").val() + "\"}";
        $.ajax({
            method: "POST",
            url: "/client",
            data: {action: "inscription", json: jason},
            success: function (texte) {
                $('#bodyInscription').css("display","none");
                $('#bodyConnexion').css("display","block");
                if($("#vousEtesBienInscrit").length == 0){
                    $('#message').append('<p class="bg-success" id="vousEtesBienInscrit">Vous êtes bien inscrit. Merci de vous connecter pour accéder au site.</p>');    
                    $("#vousEtesBienInscrit").css("color", "white");
                }
            },
            statusCode: {
                400: function(texte) {
                    if($("#soucisBizz").length == 0){
                	    $('#messageInscr').append('<p class="bg-danger" id="soucisBizz">' + texte.responseText + '</p>');
                        $("#soucisBizz").css("color", "white");
                    }else if($("#soucisBizz").length >0 && texte.responseText != $("#soucisBizz").val()){
                        $("#soucisBizz").remove();
                        $('#messageInscr').append('<p class="bg-danger" id="soucisBizz">' + texte.responseText + '</p>');
                        $("#soucisBizz").css("color", "white");
                    }
                }
            }
        });
    }
});

$("#btnFlecheRetour").click(function(){
	$('#bodyInscription').css("display","none");
    $('#bodyConnexion').css("display","block");
    $("#vousEtesBienInscrit").remove();
});

function verifErreurInscr() {
    if ($("#erreurPseudoInscr").val() != "" && $("#erreurNom").val() != ""
        && $("#erreurPrenom").val() != "" && $("#erreurEmail").val() != ""
        && $("#erreurMdpInscr").val() != "" && $("#erreurConfirmMdp").val() != "") return true;
    return false;
}
$("#btn_deconnexion").click(function(){
	document.cookie = "token=; expires=Thu, 01 Jan 1970 00:00:01 GMT;";
	$(".divGene").filter(function() { return $(this).css("display") == "block" }).css("display","none");
	$("#bodyConnexion").css("display","block");
});

function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

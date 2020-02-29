$("#senregistrer").click(function () {
    if ($("#pseudo").val() == "" && $("#erreurPseudo").length == 0) {
        $("#pseudo").css("border-color", "red");
        $("#pseudo").last().after('<p class="text-danger" id="erreurPseudo">Veuillez renseigner votre pseudo</p>');
    }
    if ($("#nom").val() == "" && $("#erreurNom").length == 0) {
        $("#nom").css("border-color", "red");
        $("#nom").last().after('<p class="text-danger" id="erreurNom">Veuillez renseigner votre nom</p>');
    }
    if ($("#prenom").val() == "" && $("#erreurPrenom").length == 0) {
        $("#prenom").css("border-color", "red");
        $("#prenom").last().after('<p class="text-danger" id="erreurPrenom">Veuillez renseigner votre prenom</p>');
    }
    var email = new RegExp('^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$');
    if (($("#email").val() == "" && $("#erreurEmail").length == 0)) {
        $("#email").css("border-color", "red");
        $("#email").last().after('<p class="text-danger" id="erreurEmail">Veuillez renseigner votre email</p>');
    } else if (!email.test($("#email").val())) {
        $("#email").css("border-color", "red");
        $("#email").last().after('<p class="text-danger" id="erreurEmail">Veuillez rentrer une adresse mail</p>');
    }
    if ($("#motDePasse").val() == "" && $("#erreurMdp").length == 0) {
        $("#motDePasse").css("border-color", "red");
        $("#motDePasse").last().after('<p class="text-danger" id="erreurMdp">Veuillez renseigner votre mot de passe</p>');
    }
    if ($("#confirmationMdp").val() == "" && $("#erreurConfirmMdp").length == 0) {
        $("#confirmationMdp").css("border-color", "red");
        $("#confirmationMdp").last().after('<p class="text-danger" id="erreurConfirmMdp">Veuillez renseigner la confirmation du mot de passe</p>');
    }
    if ($("#confirmationMdp").val() != $("#motDePasse").val()) {
        console.log("Les deux mdp ne sont pas les memes");
    }

    if (verifErreur()) {
        console.log($("#confirmationMdp").val());
        console.log($("#motDePasse").val());
        $.ajax({
            method: "POST",
            url: "/client",
            data: {
                action: "inscription", pseudo: $("#pseudo").val(),
                nom: $("#nom").val(), prenom: $("#prenom").val(),
                email: $("#email").val(), mdp: $("#motDePasse").val(),
                confirmationMdp: $("#confirmationMdp").val()
            },
            success: function () {
                console.log("merci");
            },
            error: function () {
                console.log("error");
            }
        });
    }

});

function verifErreur() {
    if ($("#erreurPseudo").val() != "" && $("#erreurNom").val() != ""
        && $("#erreurPrenom").val() != "" && $("#erreurEmail").val() != ""
        && $("#erreurMdp").val() != "" && $("#erreurConfirmMdp").val() != "") return true;
    return false;
}
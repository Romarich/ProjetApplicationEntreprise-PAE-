var barre = document.getElementById("barreDeRecherche");
barre.addEventListener('focus',test);

$("#tout").click(function(e){
	verifBarre(e, "tout");
});
$("#partenaire").click(function(e){
	verifBarre(e, "partenaire");
});
$("#mobilite").click(function(e){
	verifBarre(e, "mobilite");
});
$("#etudiant").click(function(e){
	verifBarre(e, "etudiant");
});

function test(){
	console.log("test focus");
};

function verifBarre(e, bouton){
	e.stopPropagation();
	if(bouton=="etudiant"){
		$("#tout").removeClass("active");
		$("#partenaire").removeClass("active");
		$("#mobilite").removeClass("active");
		$("#etudiant").addClass("active");
	}else if(bouton=="tout"){
		$("#etudiant").removeClass("active");
		$("#partenaire").removeClass("active");
		$("#mobilite").removeClass("active");
		$("#tout").addClass("active");
	}else if(bouton=="partenaire"){
		$("#tout").removeClass("active");
		$("#etudiant").removeClass("active");
		$("#mobilite").removeClass("active");
		$("#partenaire").addClass("active");
	}else{
		$("#tout").removeClass("active");
		$("#partenaire").removeClass("active");
		$("#etudiant").removeClass("active");
		$("#mobilite").addClass("active");
	}
};


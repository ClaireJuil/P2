package fr.ans.psc.client.democlientdam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class GetDamController {

	@GetMapping("/api")
	public String getDamModel(Model model) {

		// TODO recup du token d'API et affichage
		// appel à l'API avec le jeton d'API
		String damResponse ="{\"nationalId\":\"899700245667\",\"dams\":[{\"identifiantLieuDeTravail\":\"99700245667008\",\"typeIdentifiant\":\"Id Cabinet RPPS / N° de registre\",\"codeTypeIdentifiant\":\"6\",\"raisonSociale\":\"CABINET M DOC0024566\",\"modeExercice\":\"Libéral\",\"codeModeExercice\":\"0\",\"numActivite\":\"2102887019\",\"numAssuranceMaladie\":\"001055664\",\"dateDebutValidite\":\"26-06-2020\",\"dateFinValidite\":\"26-06-2023\",\"specialite\":\"Médecine générale\",\"codeSpecialite\":\"01\",\"conventionnement\":\"Conventionné\",\"codeConventionnel\":\"1\",\"indicateurFacturation\":\"Libellé indicateur facturation 2\",\"codeIndicateurFacturation\":\"2\",\"zoneIK\":\"Libellé Code Indemnités kilométriques 1\",\"codeZoneIK\":\"1\",\"zoneTarifaire\":\"Zone B\",\"codeZoneTarifaire\":\"24\",\"agrement1\":\"code non trouvé dans la nomenclature\",\"codeAgrement1\":\"00\",\"agrement2\":\"code non trouvé dans la nomenclature\",\"codeAgrement2\":\"00\",\"agrement3\":\"code non trouvé dans la nomenclature\",\"codeAgrement3\":\"00\",\"habilitationFse\":\"001\",\"habilitationLot\":\"001\"}]}";
		return "display-dam";
	}
}

DELETE FROM compte;
INSERT INTO compte VALUES ("1", "admin", "1234");

DELETE FROM personne;
INSERT INTO personne VALUES("1", "JAKUBCZAK", "Robin", "1995-09-28", "1");
INSERT INTO personne VALUES("2", "MARFIL", "Victor", "1997-07-09", "1");


DELETE FROM transactions;
INSERT INTO transactions VALUES("1", "Dépense", "2019-04-12", "1500", "Achat voiture", "1");
INSERT INTO transactions VALUES("2", "Dépense", "2019-04-13", "58.55", "Restaurant Chinois (Coronavirus gratuit)", "1");
INSERT INTO transactions VALUES("3", "Revenue", "2019-04-28", "2456.96", "Salaire", "2");
INSERT INTO transactions VALUES("4", "Dépense", "2019-04-12", "20.30", "Chargeur iphone", "2");
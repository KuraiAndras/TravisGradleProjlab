# TravisGradleProjlab
Better base version for the project

Commit Szabályok:
Mindenki a Developer branchről ágazik le, és oda is kér pull requestet
Csak olyan fájl-t stage-elj commitnál amire biztosan szükságünk van:
  .java
  .jar
  néhány .iml
  néhány .iml
  .txt
  Ilyen jellegű fájl valószínűleg nem fog több kelleni, pull requestet vissza kell dobni felesleges fájlok miatt
Ha tudsz pull request előtt rebase-eld a branched hogy minél kevesebb conflict legyen a merge-nél
Szükségtelen commitok legyen squasholva
A developer és master branch mindig ugyan ott tart, de először minden változtatást a masterre vezetünk
Ha travis szól hogy elakad a build, minél hamarabb javítsd ki
Commitnál csak olyat stage-elj amire biztosan szükségünk lesz. Gitkrakenből ignore-olhatod egyesével is a szükségtelen fájlokat

A többi meg peace and happiness

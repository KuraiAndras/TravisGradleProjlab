# TravisGradleProjlab
## Better base version for the project
[![Build Status](https://travis-ci.com/KuraiAndras/TravisGradleProjlab.svg?token=yaVT76QEoES76EUhS5oc&branch=Developer)](https://travis-ci.com/KuraiAndras/TravisGradleProjlab)

### Commit Szabályok:
* Mindenki a Developer branchről ágazik le, és oda is kér pull requestet
* Csak olyan fájl-t stage-elj commitnál amire biztosan szükságünk van:
    * .java
    *   .jar
    *   néhány .iml
    *   run configuration xml-ek
    *   .txt
*   Ilyen jellegű fájl valószínűleg nem fog több kelleni, pull requestet vissza kell dobni felesleges fájlok miatt
* Ha tudsz pull request előtt rebase-eld a branched hogy minél kevesebb conflict legyen a merge-nél
* Szükségtelen commitok legyen squasholva
* A developer és master branch mindig ugyan ott tart, de először minden változtatást a masterre vezetünk
* Ha travis szól hogy elakad a build, minél hamarabb javítsd ki
* Commitnál csak olyat stage-elj amire biztosan szükségünk lesz. Gitkrakenből ignore-olhatod egyesével is a szükségtelen fájlokat
* Ha csináltál valaminek branchet, az pedig be lett mergelve developerre, és már azt a branchet lezártnak tekinted, akkor töröld
#### A többi meg peace and happiness

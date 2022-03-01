/*=========FECHAS=========*/
use articulos;
db.fechas.insertOne({codigo:1, articulo:'peras', fecha: new Date()})


db.fechas.insertOne({codigo:1, articulo:'peras', fecha1: new Date('2020-11-08')})

db.fechas.insertOne({codigo:1, articulo:'peras', fecha1: new Date('2020-11-08')})

db.fechas.insertOne({codigo:1, articulo:'peras', fecha1:ISODate('2020-11-08')})



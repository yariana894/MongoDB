/*Obtener el título, precio y la editorial*/
db.libros.aggregate([
{
    $project:{
        titulo:1,
        precio:1,
        editorial:1
    }
}
])

db.libros.aggregate([
{
    $project:{
        titulo:{$toUpper:'$titulo'}
    }
                }
])

/*Agrega nueva colección con los atributos que le pasamos*/
db.libros.aggregate([
{
    $project:{
        TITULO:{$toUpper:'$titulo'},
        precio:{$toUpper:'editorial'}
    },
    },
    {
    $out:"NuevaColeccion"
    }

])

/*Obtener el título, precio e iva*/
/*multiply para multiplicar, hay que ponerlos
entre corchetes los datos que se multiplican*/
db.libros.aggregate([
{
    $project:{
        TITULO:{$toUpper:'$titulo'},
        PRECIO:{$toUpper:'$precio'},
        IVA:{$multiply:['$precio', 0.21]},
        TOTAL:{$multiply:['$precio', 1.21]}
    }
}
])

db.libros.aggregate([{
    $project:
        {
            ARTICULO:{$toUpper:'$denominacion'},
            pvp:1,
            IMPORTE: {$multiply:['$pvp', '$uv']},
            STOCKACTUAL:{$subtract:['$stock', '$uv']},
            _id:0
            }
}
])






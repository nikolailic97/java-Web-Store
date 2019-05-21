<!DOCTYPE html>
<html>
    <head>
        <title>${proizvod.name}</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/css/style.css">
        </head>
    <body class="pozadina">
        <h1>${proizvod.name}</h1>
        <div>
            <img src="/images/${proizvod.image}" alt="${proizvod.name}">
        </div>
        <p><b>Price:</b> ${proizvod.price}</p>
        <p><b>Manufacturer:</b> ${proizvod.manufacturer}</p>
        <p><b>Category:</b> ${proizvod.category}</p>
    </body>
</html>

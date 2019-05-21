<!DOCTYPE html>
<html>
    <head>
        <title>Homepage</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body class="pozadina">
        <h1>Filtered products</h1>
        <div class="products">
        <#list proizvodi as p>
            <div class="product">
                <h3>${p.name}</h3>
                <div>
                    <img src="/images/${p.image}" alt="${p.name}">
                </div>
                <div>
                    <p><a href="/proizvodi/${p.ID}">Detalji</a></p>
                </div>
            </div>
        </#list>
        </div>
    </body>
</html>

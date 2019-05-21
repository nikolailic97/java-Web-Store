<!DOCTYPE html>
<html>
    <head>
        <title>Homepage</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body class="pozadina">
        <h1>Web Store</h1>
        <p>Contact us <a class="detalji" href="/contact">here</a>.</p>
        <h2 id="akcija">Featured Product</h2>
        <h3>${proizvod.name}</h3>
        <div>
            <img src="/images/${proizvod.image}" alt="${proizvod.name}">
        </div>
        
        <h2>All products</h2>
        <div>
            Min: <input type="number" id="min">
            Max: <input type="number" id="max">
            <button type="button" id="search">Search</button>
        </div>
        <div>
            <form action="/search" method="get">
                Category: <input type="text" name="category">
                <button type="submit">Search</button>
            </form>
        </div>
        <div class="products">
        <#list proizvodi as p>
            <div class="product">
                <h3>${p.name}</h3>
                <div>
                    <img src="/images/${p.image}" alt="${p.name}">
                </div>
                <div>
                    <p class="detalji"><a class="detalji" href="/proizvodi/${p.ID}">Detalji</a></p>
                </div>
            </div>
        </#list>
        </div>
        <script>
            document.querySelector("#search").onclick = function() 
            {
                let min = document.querySelector("#min").value;
                let max = document.querySelector("#max").value; 
                window.location = "/proizvodi/" + min 
                + "/" + max;
            }
        </script>
    </body>
</html>

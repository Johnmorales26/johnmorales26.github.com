<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,
        initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Selección</title>
    <link href="http://fonts.cdnfonts.com/css/monument-extended" rel="stylesheet">
    <link rel="shortcut icon" href="../Muestras/LOGO.ico" type="image/x-icon">
    <link rel="stylesheet" href="styles.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>

<body>
    <img src="../Muestras/1.png" width="400" height="100" class="logo">
    <img src="../Muestras/user.png" width="97" height="100" class="user-img">
    <h3 class="user">USUARIO</h3>

    <a href="../destinos/destinos.php" class="button1">
        Destinos
    </a>
    <a href="../servicios/servicios.php" class="button1">
        Servicios
    </a>
    <a href="#" class="button1">
        Contacto
    </a>
    <div class="vuelos">
        <h5>VUELOS</h5>
    </div>
    <div class="container">
        <br>
        <form class="options1">
            <input type="radio" id="male" name="gender" value="male">
            <label for="male">De ida y vuelta</label><br>
            <input type="radio" id="female" name="gender" value="female">
            <label for="female">Solo ida</label><br>
        </form>
        <form class="options2">
            <label for="origen">Origen</label>
            <select>
                <option value="México">México</option>
                <option value="Estados Unidos">Estados Unidos</option>
                <option value="Otro">Otro</option>
            </select>
        </form>
        <form class="options3">
            <label for="destino">Destino</label>
            <select>
                <option value="italia">Italia</option>
                <option value="francia">Francia</option>
                <option value="mexico">México</option>
                <option value="EUA">Estados Unidos</option>
                <option value="rusia">Rusia</option>
                <option value="espana">España</option>
                <option value="polonia">Polonia</option>
                <option value="austria">Austria</option>
                <option value="uk">Reino Unido</option>
                <option value="alemania">Alemania</option>
                <option value="japon">Japón</option>
                <option value="coreasur">Corea del sur</option>
                <option value="china">China</option>
            </select>
        </form>
        <form class="date1">
            <label for="start">Fecha de partida</label><br>
            <input type="date" id="start" name="trip-start" value="2021-01-01" min="2021-01-01" max="2022-12-31">
        </form>
        <form class="date2">
            <label for="start">Fecha de regreso (Si es el caso)</label><br>
            <input type="date" id="start" name="trip-start" value="2021-01-01" min="2021-01-01" max="2022-12-31">
        </form>
        <form class="options4">
            <label for="adults">Adultos</label>
            <select>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4more">4+</option>
            </select>
        </form>
        <form class="options5">
            <label for="kids">Niños</label>
            <select>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4more">4+</option>
            </select>
        </form>
        <form class="options6">
            <label for="bays">Bebés (Si es el caso)</label>
            <select>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4more">4+</option>
            </select>
        </form>
        <button class="search">
            Buscar vuelo
        </button>
    </div>
    <div class="wrapper">
        <div class="icon facebook">
            <div class="tooltip">
                Facebook
            </div>
            <span><i class="fab fa-facebook-f"></i></span>
        </div>
        <div class="icon twitter">
            <div class="tooltip">
                Twitter
            </div>
            <span><i class="fab fa-twitter"></i></span>
        </div>
        <div class="icon instagram">
            <div class="tooltip">
                Instagram
            </div>
            <span><i class="fab fa-instagram"></i></span>
        </div>
        <div class="icon github">
            <div class="tooltip">
                Github
            </div>
            <span><i class="fab fa-github"></i></span>
        </div>
        <div class="icon youtube">
            <div class="tooltip">
                YouTube
            </div>
            <span><i class="fab fa-youtube"></i></span>
        </div>
    </div>

    <div class="next">
        <div class="btn-next">
            <button type="button" onclick="javascript:window.history.back();">← Atras</button>
        </div>
    </div>
</body>
<script src="../scripts/cursor.js"></script>

</html>
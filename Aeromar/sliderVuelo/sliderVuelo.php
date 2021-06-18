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
    <link rel="stylesheet" href="sliderVuelo.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>

<body>
    <img src="../Muestras/1.png" width="400" height="100" class="logo">
    <img src="../Muestras/user.png" width="97" height="100" class="user-img">
    <div class="buttons-options">
        <div class="options">
            <p class="step1">SELECCIONAR →</p>
            <p class="step2">RESERVAR → </p>
            <p class="step3">PAGAR</p>
        </div>
    </div>

    <div class="boxtext">
        <p class="text1">Escoja un vuelo. El precio total se calculará según su selección.</p>
        <p class="text2">Tenga en cuenta que si cabia la selección, el precio se puede volver a calcular.</p>
        <p class="text3">El precio total más bajo se indica con este símbolo:</p>
    </div>
    <h3 class="user">USUARIO</h3>
    <div class="container">
        <ul class="slider">
            <li id="slide1">
                <img src="../Muestras/ClaseTurista.png" />
            </li>
            <li id="slide2">
                <img src="../Muestras/ClaseSuperior.png" />
            </li>
            <li id="slide3">
                <img src="../Muestras/ClaseBussinesOEjecutiva.png" />
            </li>
            <li id="slide4">
                <img src="../Muestras/PrimerClase.png" />
            </li>
        </ul>
        <ul class="menu">
            <li>
                <a href="#slide1">1</a>
            </li>
            <li>
                <a href="#slide2">2</a>
            </li>
            <li>
                <a href="#slide3">3</a>
            </li>
            <li>
                <a href="#slide4">4</a>
            </li>
        </ul>
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
                <button type="button" onclick="window.location.href='../reservar/reservar.php'" >Siguiente →</button>
            </div>
        </div>
</body>
<script src="../scripts/cursor.js"></script>

</html>
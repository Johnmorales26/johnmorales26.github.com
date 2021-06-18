<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,
        initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservaciones</title>
    <link href="http://fonts.cdnfonts.com/css/monument-extended" rel="stylesheet">
    <link rel="shortcut icon" href="../Muestras/LOGO.ico" type="image/x-icon">
    <link rel="stylesheet" href="styles.css" />
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
    <h3 class="user">USUARIO</h3>
    <div class="optioncontainter">
        <h1>VUELO SELECCIONADO</h1>
    </div>

    <div class="reservation">
        <br><br><br>
        <div class="elements">
            <label for="dateofbirth">Fecha de partida</label>
            <input type="date" name="dateofbirth" id="dateofbirth">
        </div>
        <br><br>
        <div class="elements">
            <label for="dateofbirth">Fecha de llegada</label>
            <input type="date" name="dateofbirth" id="dateofbirth">
        </div>
        <br><br>
        <div class="elements">
            <h2>CIUDAD DE DESTINO</h2>
            <input type="text" placeholder="p.ej. Japón">
        </div>
        <br><br>
        <div class="elements">
            <h2>NÚMERO DE VUELO</h2>
            <div id="string_inner_container" class="random">
        </div>
        </div>
    </div>
    <div class="container">
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
                <button type="button" onclick="window.location.href='../pago/pago.php'">Siguiente →</button>
            </div>
        </div>
        <div class="next">
            <div class="btn-back">
                <button type="button" onclick="window.location.href='../sliderVuelo/sliderVuelo.php'"> ←
                    Retroceder</button>
            </div>
        </div>
</body>
<script src="../scripts/cursor.js"></script>

<script src="../scripts/reservar.js"></script>

</html>
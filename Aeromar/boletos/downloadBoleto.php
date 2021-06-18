<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,
    initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Boleto</title>
    <link href="http://fonts.cdnfonts.com/css/monument-extended" rel="stylesheet">
    <link rel="shortcut icon" href="../Muestras/LOGO.ico" type="image/x-icon">
    <link rel="stylesheet" href="styles_downloadBoleto.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>

<body>
    <a href="../destinos/destinos.php" class="button1">
        Destinos
    </a>
    <a href="../servicios/servicios.php" class="button1">
        Servicios
    </a>
    <a href="#" class="button1">
        Contacto
    </a>
    <a href="javascript:window.history.back();" class="return">
        Atras
    </a>

    <img src="../Muestras/1.png" width="400" height="100">
    <div class="padre">
        <div class="hijo">
            <embed src="Boleto.pdf" type="application/pdf" width="100%" height="600px" />
        </div>
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
</body>
<script src="../scripts/cursor.js"></script>

</html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,
        initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagos</title>
    <link href="http://fonts.cdnfonts.com/css/monument-extended" rel="stylesheet">
    <link rel="shortcut icon" href="../Muestras/LOGO.ico" type="image/x-icon">
    <link rel="stylesheet" href="styles.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
</head>

<body>
    <div class="container">
        <div class="left column">
            <div class="logo">
                <ion-icon name="finger-print"></ion-icon>
            </div>
            <div class="header">
                <h1 class="ml12">PAGO DE FACTURA</h1>
            </div>
            <div class="back-btn" onclick="window.location.href='../reservar/reservar.php'">⟵ Regresar</div>
            <div class="price">
                <span>Total</span>
                <span>$1500.00</span>
            </div>
            <div class="message">
                <h1>"Una vez confirmado su pago, su boleto será mostrado en una pantalla nueva para imprimir"</h1>
            </div>
        </div>
        <div class="right column">
            <div class="nav">
                <div class="nav-item active">SELECCIONAR</div>
                ➝
                <div class="nav-item active">RESERVAR</div>
                ➝
                <div class="nav-item">PAGAR</div>
            </div>
            <div class="card-img">
                <img src="../Muestras/card.png" alt="" />
            </div>
            <div class="form">
                <div class="form-row">
                    <input type="text" placeholder="Número de tarjeta" />
                </div>
                <div class="form-row">
                    <input type="text" placeholder="Fecha" />
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <input type="text" placeholder="CVV" />
                </div>
            </div>
            <div class="btn">
                <button>Confirmar</button>
            </div>
        </div>
    </div>
<script src="../scripts/pago.js"></script>
<script src="../scripts/cursor.js"></script>
</body>

</html>
<?php
    $base=isset($_POST["base"])?$_POST["base"]:0;
    $altura=isset($_POST["altura"])?$_POST["altura"]:0;

    $area=$base*$altura;
?>
<html>
<head>
    <title>Área do retângulo</title>
</head>
<body>
    <form action="index.php" method="post">
        <Label for="base">Digite a base</Label>
        <input type="text" name="base" id="base">

        <Label for="base">Digite a altura</Label>
        <input type="text" name="altura" id="altura">

        <input type="submit" value="Calcular">
    </form>
    <?php
        if ($area != 0) {
            echo("<p>A área é $area</p>");
        }
    ?>
</body>
</html>
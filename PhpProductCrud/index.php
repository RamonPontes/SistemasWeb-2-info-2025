<?php
    $db = mysqli_connect("localhost", "root", "vertrigo", "Ramon2Info");
    if ($db->connect_errno) {
        echo "Ocorreu um erro na conexão com o banco de dados";
        exit;
    } else {
        $sel=isset($_POST["sel"])?$_POST["sel"]:"";
        $id=isset($_POST["id"])?$db->real_escape_string($_POST["id"]):"";
        $name=isset($_POST["name"])?$db->real_escape_string($_POST["name"]):"";
        $price=isset($_POST["price"])?$db->real_escape_string($_POST["price"]):"";
        $oper=isset($_POST["oper"])?$_POST["oper"]:"";
        switch ($oper) {
            case 'Insere':
                $cmd=$db->prepare("insert into products (name,price) values(?,?)");
                $cmd->bind_param("sd", $name, $price);
                if ($cmd->execute()) {
                    echo "Produto inserido";
                } else {
                    echo "Não foi possivel inserir ->".$cmd->error;
                }
                break;
            case 'Excluir':
                $cmd=$db->prepare("delete from products where id=?");
                $cmd->bind_param("i", $sel);
                if ($cmd->execute()) {
                    echo "Produto inserido";
                } else {
                    echo "Não foi possivel inserir ->".$cmd->error;
                }
                break;
            case 'Altera':
                $cmd=$db->prepare("update products set name=?,price=? where id=?");
                $cmd->bind_param("sdi", $name, $price, $id);

                if ($cmd->execute()) {
                    echo "Elemento alterado";
                } else {
                    echo "Não foi possivel alterar ->".$cmd->error;
                }
                break;
            case 'Alterar':
                if ($sel) {
                    $cmd=$db->prepare("select * from products where id=?");
                    $cmd->bind_param("i",$sel);
                    $cmd->execute();
                    $lista=$cmd->get_result();
                    $result=$lista->fetch_assoc();
                    $id = $result["id"];
                    $name = $result["name"];
                    $price = $result["price"];
                } else {
                    $oper = "";
                }
            default:
                break;
        }

        $tabela = "<table border=1><tr><th></th><th>ID</th><th>Name</th><th>Price</th></tr>";
                    
        $cmd=$db->prepare("select * from products order by id");
        $cmd->execute();
        $lista=$cmd->get_result();

        while($result=$lista->fetch_assoc()) {
            $tabela.="<tr><td><input type='radio' name='sel' value='".$result["id"]."'></td>";
            $tabela.="<td>".$result["id"]."</td>";
            $tabela.="<td>".$result["name"]."</td>";
            $tabela.="<td>".$result["price"]."</td></tr>";
        }
        $tabela.="</table>";
        $cmd->close();
    }
?>

<html>
<body>
    <form method="post">
        <input type="submit" value="Novo" name="oper">
        <input type="submit" value="Alterar" name="oper">
        <input type="submit" value="Excluir" name="oper">

        <?php
            echo $tabela;
            if ($oper == "Novo" || $oper == "Alterar") {
                if ($oper == "Novo") {
                    $id = "";
                    $name = "";
                    $price = "";
                }
                echo "Id<input type='text' name='id'
                        value='$id' readonly><br>";
                echo "Name<input type='text' name='name' value='$name'
                        maxlength='50'><br>";
                echo "Price<input type='text' name='price' value='$price'
                    maxlength='14'><br>";
                echo "<input type='submit' name='oper' value='Cancelar'>";
                
                if ($oper == "Novo") {
                    echo "<input type='submit' name='oper' value='Insere'>";
                }else{
                    echo "<input type='submit' name='oper' value='Altera'>";
                }
            }
        ?>
    </form>
</body>
</html>
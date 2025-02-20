<?php
    $db = mysqli_connect("localhost", "root", "vertrigo", "pessoa");
    if ($db->connect_errno) {
        echo "Ocorreu um erro na conexão com o banco de dados";
        exit;
    } else {
        $codigo=isset($_POST["codigo"])?$db->real_escape_string($_POST["codigo"]):"";
        $nome=isset($_POST["nome"])?$db->real_escape_string($_POST["nome"]):"";
        $cpf=isset($_POST["cpf"])?$db->real_escape_string($_POST["cpf"]):"";
        $oper=isset($_POST["oper"])?$_POST["oper"]:"";
        $sel=isset($_POST["sel"])?$_POST["sel"]:"";
        switch ($oper) {
            case 'Insere':
                $cmd=$db->prepare("insert into pessoa (nome,cpf) values(?,?)");
                $cmd->bind_param("ss",$nome,$cpf);
                if ($cmd->execute()) {
                    echo "Elemento inserido";
                } else {
                    echo "Não foi possivel inserir ->".$cmd->error;
                }
                break;
            case 'Excluir':
                $cmd=$db->prepare("delete from pessoa where codigo=?");
                $cmd->bind_param("i", $sel);

                if ($cmd->execute()) {
                    echo "Elemento excluido";
                } else {
                    echo "Não foi possivel excluir ->".$cmd->error;
                }
                break;
            case 'Altera':
                $cmd=$db->prepare("update pessoa set nome=?,cpf=? where codigo=?");
                $cmd->bind_param("ssi", $nome, $cpf, $codigo);

                if ($cmd->execute()) {
                    echo "Elemento alterado";
                } else {
                    echo "Não foi possivel alterar ->".$cmd->error;
                }
                break;
            case 'Alterar':
                if ($sel) {
                    $cmd=$db->prepare("select * from pessoa where codigo=?");
                    $cmd->bind_param("i",$sel);
                    $cmd->execute();
                    $lista=$cmd->get_result();
                    $result=$lista->fetch_assoc();
                    $codigo = $result["codigo"];
                    $nome = $result["nome"];
                    $cpf = $result["cpf"];
                } else {
                    $oper = "";
                }

            default:
                break;
        }
        
        $tabela = "<table border=1><tr><th></th><th>C&oacutedigo</th>
                    <th>Nome</th><th>CPF</th></tr>";
                    
        $cmd=$db->prepare("select * from pessoa order by codigo");
        $cmd->execute();
        $lista=$cmd->get_result();

        while($result=$lista->fetch_assoc()) {
            $tabela.="<tr><td><input type='radio' name='sel' value='".$result["codigo"]."'></td>";
            $tabela.="<td>".$result["codigo"]."</td>";
            $tabela.="<td>".$result["nome"]."</td>";
            $tabela.="<td>".$result["cpf"]."</td></tr>";
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
                    $codigo = "";
                    $nome = "";
                    $cpf = "";
                }
                echo "C&oacutedigo<input type='text' name='codigo'
                        value='$codigo' readonly><br>";
                echo "Nome<input type='text' name='nome' value='$nome'
                        maxlength='50'><br>";
                echo "CPF<input type='text' name='cpf' value='$cpf'
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
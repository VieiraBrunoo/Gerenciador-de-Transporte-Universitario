<?php

define('EMAIL_FOR_REPORTS', '');
define('RECAPTCHA_PRIVATE_KEY', '@privatekey@');
define('FINISH_URI', 'http://');
define('FINISH_ACTION', 'message');
define('FINISH_MESSAGE', 'Thanks for filling out my form!');
define('UPLOAD_ALLOWED_FILE_TYPES', 'doc, docx, xls, csv, txt, rtf, html, zip, jpg, jpeg, png, gif');

define('_DIR_', str_replace('\\', '/', dirname(__FILE__)) . '/');
require_once _DIR_ . '/handler.php';

?>

<?php if (frmd_message()): ?>
<link rel="stylesheet" href="<?php echo dirname($form_path); ?>/formoid-solid-blue.css" type="text/css" />
<span class="alert alert-success"><?php echo FINISH_MESSAGE; ?></span>
<?php else: ?>
<!-- Start Formoid form-->
<link rel="stylesheet" href="<?php echo dirname($form_path); ?>/formoid-solid-blue.css" type="text/css" />
<script type="text/javascript" src="<?php echo dirname($form_path); ?>/jquery.min.js"></script>
<form class="formoid-solid-blue" style="background-color:#FFFFFF;font-size:14px;font-family:'Roboto',Arial,Helvetica,sans-serif;color:#34495E;max-width:600px;min-width:150px" method="post"><div class="title"><h2>Cadastro Motorista</h2></div>
	<div class="element-input<?php frmd_add_class("input"); ?>"><label class="title"></label><div class="item-cont"><input class="medium" type="text" name="input" placeholder="Matricula Motorista"/><span class="icon-place"></span></div></div>
	<div class="element-input<?php frmd_add_class("input1"); ?>"><label class="title"></label><div class="item-cont"><input class="large" type="text" name="input1" placeholder="Nome"/><span class="icon-place"></span></div></div>
	<div class="element-input<?php frmd_add_class("input2"); ?>"><label class="title"></label><div class="item-cont"><input class="medium" type="text" name="input2" placeholder="Numero Habilitação"/><span class="icon-place"></span></div></div>
	<div class="element-input<?php frmd_add_class("input5"); ?>"><label class="title"></label><div class="item-cont"><input class="large" type="text" name="input5" placeholder="Endereço"/><span class="icon-place"></span></div></div>
	<div class="element-input<?php frmd_add_class("input4"); ?>"><label class="title"></label><div class="item-cont"><input class="medium" type="text" name="input4" placeholder="Bairro"/><span class="icon-place"></span></div></div>
	<div class="element-input<?php frmd_add_class("input3"); ?>"><label class="title"></label><div class="item-cont"><input class="medium" type="text" name="input3" placeholder="Cidade"/><span class="icon-place"></span></div></div>
	<div class="element-radio<?php frmd_add_class("radio"); ?>"><label class="title">Sexo</label>		<div class="column column2"><label><input type="radio" name="radio" value="Masculino" /><span>Masculino</span></label></div><span class="clearfix"></span>
		<div class="column column2"><label><input type="radio" name="radio" value="Feminino" /><span>Feminino</span></label></div><span class="clearfix"></span>
</div>
	<div class="element-input<?php frmd_add_class("input6"); ?>"><label class="title"></label><div class="item-cont"><input class="medium" type="text" name="input6" placeholder="CPF"/><span class="icon-place"></span></div></div>
	<div class="element-radio<?php frmd_add_class("radio1"); ?>"><label class="title">Estado Civil</label>		<div class="column column2"><label><input type="radio" name="radio1" value="Solteiro (a)" /><span>Solteiro (a)</span></label><label><input type="radio" name="radio1" value="Divorciado (a)" /><span>Divorciado (a)</span></label></div><span class="clearfix"></span>
		<div class="column column2"><label><input type="radio" name="radio1" value="Casado (a)" /><span>Casado (a)</span></label><label><input type="radio" name="radio1" value="Viúvo (a)" /><span>Viúvo (a)</span></label></div><span class="clearfix"></span>
</div>
	<div class="element-date<?php frmd_add_class("date"); ?>"><label class="title"></label><div class="item-cont"><input class="large" data-format="yyyy-mm-dd" type="date" name="date" placeholder="Data Nascimento"/><span class="icon-place"></span></div></div>
<div class="submit"><input type="submit" value="Cadastrar"/></div></form><script type="text/javascript" src="<?php echo dirname($form_path); ?>/formoid-solid-blue.js"></script>

<!-- Stop Formoid form-->
<?php endif; ?>

<?php frmd_end_form(); ?>
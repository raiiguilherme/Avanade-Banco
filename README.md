# Projeto Banco-AVANADE

#### O projeto consiste em um serviço de criação de conta bancaria e um microsserviço de disparo de emails. Ao criar uma conta no seriço bancário, é enviado uma mensagem para o RABBITMQ( Messageria) que enviar os dados para o serviço de email, este por sua vez armazena a mensagemem um banco de dados e dispara o email no Mailtrap (Serviço de teste de emails).
 

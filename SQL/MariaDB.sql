CREATE TABLE usuarios(
	id INT,
  	NOME VARCHAR(255) NOT NULL COMMENT 'Nome de usuário',
  	email VARCHAR(100) NOT NULL UNIQUE COMMENT 'Email do usuário',
  	endereco VARCHAR(50) NOT NULL COMMENT 'Endereço do usuário',
  	data_nascomento DATE NOT NULL COMMENT 'Data de nascimento');
        
CREATE TABLE reservas(
    id INT COMMENT 'Identificador da reserva',
    id_usuario INT COMMENT 'Referência ao ID do usuário que fez a reserva',
    id_destino INT COMMENT 'Referência ao ID do destino da reserva',
    data_reserva DATE COMMENT 'Data da reserva',
    status ENUM('pendente', 'confirmada', 'cancelada') DEFAULT 'pendente' COMMENT 'Status da reserva'
);

    
 CREATE TABLE destinos(
   id INT,
   nome VARCHAR(255) not NULL UNIQUE COMMENT'Nome de destino',
   descricao VARCHAR(255) not NULL COMMENT'descrição do destino');
   
   
    
CREATE DATABASE cassino_online;
USE cassino_online;

-- =========================
-- 1. TABELAS SIMPLES
-- =========================

CREATE TABLE Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(255),
    data_cadastro DATETIME
);

CREATE TABLE Jogo (
    id_jogo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    tipo VARCHAR(50),
    descricao TEXT
);

CREATE TABLE MetodoPagamento (
    id_metodo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50)
);

-- =========================
-- 2. TABELAS COM FK
-- =========================

CREATE TABLE Carteira (
    id_carteira INT AUTO_INCREMENT PRIMARY KEY,
    saldo DECIMAL(10,2),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE Transacao (
    id_transacao INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10,2),
    tipo VARCHAR(20),
    data DATETIME,
    id_usuario INT,
    id_metodo INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_metodo) REFERENCES MetodoPagamento(id_metodo)
);

CREATE TABLE Partida (
    id_partida INT AUTO_INCREMENT PRIMARY KEY,
    data DATETIME,
    resultado VARCHAR(50),
    id_usuario INT,
    id_jogo INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_jogo) REFERENCES Jogo(id_jogo)
);

CREATE TABLE Aposta (
    id_aposta INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10,2),
    resultado VARCHAR(20),
    id_partida INT,
    FOREIGN KEY (id_partida) REFERENCES Partida(id_partida)
);

CREATE TABLE Bonus (
    id_bonus INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10,2),
    tipo VARCHAR(50),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

-- =========================
-- 3. TABELAS COM DEPENDÊNCIA (TIPO VENDA)
-- =========================

CREATE TABLE Deposito (
    id_deposito INT AUTO_INCREMENT PRIMARY KEY,
    data DATETIME,
    valor_total DECIMAL(10,2),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE ItensDeposito (
    id_item INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10,2),
    id_deposito INT,
    id_metodo INT,
    FOREIGN KEY (id_deposito) REFERENCES Deposito(id_deposito),
    FOREIGN KEY (id_metodo) REFERENCES MetodoPagamento(id_metodo)
);

CREATE TABLE Saque (
    id_saque INT AUTO_INCREMENT PRIMARY KEY,
    data DATETIME,
    valor_total DECIMAL(10,2),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE ItensSaque (
    id_item INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10,2),
    id_saque INT,
    id_metodo INT,
    FOREIGN KEY (id_saque) REFERENCES Saque(id_saque),
    FOREIGN KEY (id_metodo) REFERENCES MetodoPagamento(id_metodo)
);
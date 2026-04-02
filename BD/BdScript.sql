-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           12.0.2-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para pigjackpot
DROP DATABASE IF EXISTS `pigjackpot`;
CREATE DATABASE IF NOT EXISTS `pigjackpot` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;
USE `pigjackpot`;

-- Copiando estrutura para tabela pigjackpot.aposta
DROP TABLE IF EXISTS `aposta`;
CREATE TABLE IF NOT EXISTS `aposta` (
  `id_aposta` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,2) DEFAULT NULL,
  `resultado` varchar(20) DEFAULT NULL,
  `id_partida` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_aposta`),
  KEY `id_partida` (`id_partida`),
  CONSTRAINT `aposta_ibfk_1` FOREIGN KEY (`id_partida`) REFERENCES `partida` (`id_partida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.aposta: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.bonus
DROP TABLE IF EXISTS `bonus`;
CREATE TABLE IF NOT EXISTS `bonus` (
  `id_bonus` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,2) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_bonus`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `bonus_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.bonus: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.carteira
DROP TABLE IF EXISTS `carteira`;
CREATE TABLE IF NOT EXISTS `carteira` (
  `id_carteira` int(11) NOT NULL AUTO_INCREMENT,
  `saldo` decimal(10,2) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_carteira`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `carteira_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.carteira: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.deposito
DROP TABLE IF EXISTS `deposito`;
CREATE TABLE IF NOT EXISTS `deposito` (
  `id_deposito` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `valor_total` decimal(10,2) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_deposito`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `deposito_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.deposito: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.itensdeposito
DROP TABLE IF EXISTS `itensdeposito`;
CREATE TABLE IF NOT EXISTS `itensdeposito` (
  `id_item` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,2) DEFAULT NULL,
  `id_deposito` int(11) DEFAULT NULL,
  `id_metodo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `id_deposito` (`id_deposito`),
  KEY `id_metodo` (`id_metodo`),
  CONSTRAINT `itensdeposito_ibfk_1` FOREIGN KEY (`id_deposito`) REFERENCES `deposito` (`id_deposito`),
  CONSTRAINT `itensdeposito_ibfk_2` FOREIGN KEY (`id_metodo`) REFERENCES `metodopagamento` (`id_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.itensdeposito: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.itenssaque
DROP TABLE IF EXISTS `itenssaque`;
CREATE TABLE IF NOT EXISTS `itenssaque` (
  `id_item` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,2) DEFAULT NULL,
  `id_saque` int(11) DEFAULT NULL,
  `id_metodo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `id_saque` (`id_saque`),
  KEY `id_metodo` (`id_metodo`),
  CONSTRAINT `itenssaque_ibfk_1` FOREIGN KEY (`id_saque`) REFERENCES `saque` (`id_saque`),
  CONSTRAINT `itenssaque_ibfk_2` FOREIGN KEY (`id_metodo`) REFERENCES `metodopagamento` (`id_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.itenssaque: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.jogo
DROP TABLE IF EXISTS `jogo`;
CREATE TABLE IF NOT EXISTS `jogo` (
  `id_jogo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `descricao` text DEFAULT NULL,
  PRIMARY KEY (`id_jogo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.jogo: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.metodopagamento
DROP TABLE IF EXISTS `metodopagamento`;
CREATE TABLE IF NOT EXISTS `metodopagamento` (
  `id_metodo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.metodopagamento: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.partida
DROP TABLE IF EXISTS `partida`;
CREATE TABLE IF NOT EXISTS `partida` (
  `id_partida` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `resultado` varchar(50) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_jogo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_partida`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_jogo` (`id_jogo`),
  CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `partida_ibfk_2` FOREIGN KEY (`id_jogo`) REFERENCES `jogo` (`id_jogo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.partida: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.saque
DROP TABLE IF EXISTS `saque`;
CREATE TABLE IF NOT EXISTS `saque` (
  `id_saque` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `valor_total` decimal(10,2) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_saque`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `saque_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.saque: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.transacao
DROP TABLE IF EXISTS `transacao`;
CREATE TABLE IF NOT EXISTS `transacao` (
  `id_transacao` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,2) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_metodo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_transacao`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_metodo` (`id_metodo`),
  CONSTRAINT `transacao_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `transacao_ibfk_2` FOREIGN KEY (`id_metodo`) REFERENCES `metodopagamento` (`id_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.transacao: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela pigjackpot.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Copiando dados para a tabela pigjackpot.usuario: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

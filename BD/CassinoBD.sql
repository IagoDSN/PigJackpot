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


-- Copiando estrutura do banco de dados para cassinoonline
DROP DATABASE IF EXISTS `cassinoonline`;
CREATE DATABASE IF NOT EXISTS `cassinoonline` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `cassinoonline`;

-- Copiando estrutura para tabela cassinoonline.aposta
DROP TABLE IF EXISTS `aposta`;
CREATE TABLE IF NOT EXISTS `aposta` (
  `id_aposta` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,2) NOT NULL,
  `resultado` varchar(150) NOT NULL,
  `id_partida` int(11) NOT NULL,
  PRIMARY KEY (`id_aposta`),
  KEY `id_partida` (`id_partida`),
  CONSTRAINT `aposta_ibfk_1` FOREIGN KEY (`id_partida`) REFERENCES `partida` (`id_partida`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.aposta: ~1 rows (aproximadamente)
INSERT INTO `aposta` (`id_aposta`, `valor`, `resultado`, `id_partida`) VALUES
	(1, 20.00, 'x2', 1);

-- Copiando estrutura para tabela cassinoonline.bonus
DROP TABLE IF EXISTS `bonus`;
CREATE TABLE IF NOT EXISTS `bonus` (
  `id_bonus` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,2) NOT NULL,
  `tipo` varchar(150) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_bonus`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `bonus_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.bonus: ~2 rows (aproximadamente)
INSERT INTO `bonus` (`id_bonus`, `valor`, `tipo`, `id_usuario`) VALUES
	(1, 0.10, 'double win', 8),
	(2, 0.10, 'double win', 8);

-- Copiando estrutura para tabela cassinoonline.carteira
DROP TABLE IF EXISTS `carteira`;
CREATE TABLE IF NOT EXISTS `carteira` (
  `id_carteira` int(11) NOT NULL AUTO_INCREMENT,
  `saldo` decimal(10,2) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_carteira`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `carteira_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.carteira: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela cassinoonline.conquista
DROP TABLE IF EXISTS `conquista`;
CREATE TABLE IF NOT EXISTS `conquista` (
  `id_conquista` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `descricao` text DEFAULT NULL,
  `recompensa` double DEFAULT NULL,
  PRIMARY KEY (`id_conquista`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.conquista: ~0 rows (aproximadamente)
INSERT INTO `conquista` (`id_conquista`, `nome`, `descricao`, `recompensa`) VALUES
	(4, 'PockerKing', 'ganhe', 45000.23);

-- Copiando estrutura para tabela cassinoonline.deposito
DROP TABLE IF EXISTS `deposito`;
CREATE TABLE IF NOT EXISTS `deposito` (
  `id_deposito` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `valor_total` decimal(10,2) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_deposito`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `deposito_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.deposito: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela cassinoonline.jogo
DROP TABLE IF EXISTS `jogo`;
CREATE TABLE IF NOT EXISTS `jogo` (
  `id_jogo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `tipo` varchar(150) NOT NULL,
  `descricao` text NOT NULL,
  PRIMARY KEY (`id_jogo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.jogo: ~3 rows (aproximadamente)
INSERT INTO `jogo` (`id_jogo`, `nome`, `tipo`, `descricao`) VALUES
	(1, 'truco', 'cartas', 'Um clássico jogo de cartas cheio de blefes, estratégia e emoção a cada rodada.'),
	(2, 'Poker', 'cartas', 'Teste sua sorte e habilidade em partidas intensas onde cada decisão pode valer tudo.'),
	(3, 'Roleta', 'Mesa', 'Teste sua sorte e habilidade em partidas intensas onde cada decisão pode valer tudo.');

-- Copiando estrutura para tabela cassinoonline.partida
DROP TABLE IF EXISTS `partida`;
CREATE TABLE IF NOT EXISTS `partida` (
  `id_partida` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `resultado` varchar(150) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_jogo` int(11) NOT NULL,
  PRIMARY KEY (`id_partida`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_jogo` (`id_jogo`),
  CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `partida_ibfk_2` FOREIGN KEY (`id_jogo`) REFERENCES `jogo` (`id_jogo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.partida: ~1 rows (aproximadamente)
INSERT INTO `partida` (`id_partida`, `data`, `resultado`, `id_usuario`, `id_jogo`) VALUES
	(1, '2026-05-31 00:00:00', 'Win', 8, 2);

-- Copiando estrutura para tabela cassinoonline.saque
DROP TABLE IF EXISTS `saque`;
CREATE TABLE IF NOT EXISTS `saque` (
  `id_saque` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `valor_total` decimal(10,2) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_saque`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `saque_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.saque: ~0 rows (aproximadamente)
INSERT INTO `saque` (`id_saque`, `data`, `valor_total`, `id_usuario`) VALUES
	(2, '2026-06-08 00:00:00', 25.00, 8);

-- Copiando estrutura para tabela cassinoonline.transacao
DROP TABLE IF EXISTS `transacao`;
CREATE TABLE IF NOT EXISTS `transacao` (
  `id_transacao` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,2) NOT NULL,
  `tipo` varchar(150) NOT NULL,
  `data` datetime NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_transacao`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `transacao_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.transacao: ~0 rows (aproximadamente)
INSERT INTO `transacao` (`id_transacao`, `valor`, `tipo`, `data`, `id_usuario`) VALUES
	(2, 234.00, 'pix2', '2026-06-08 00:00:00', 8);

-- Copiando estrutura para tabela cassinoonline.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `senha` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `data_cadastro` date NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `cpf` varchar(50) NOT NULL,
  `data_nascimento` date NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.usuario: ~5 rows (aproximadamente)
INSERT INTO `usuario` (`id_usuario`, `nome`, `senha`, `email`, `data_cadastro`, `endereco`, `cpf`, `data_nascimento`) VALUES
	(8, 'Iago', '1234', 'te@gmail.com', '2026-05-04', 'rty', '1357123', '2026-05-20'),
	(10, 'as', '1234', 'asda@gmail.com', '2026-04-26', 're2', '000.000.000-05', '2026-05-18'),
	(12, 'as', '1234', 'asda@gmail.com', '2026-04-26', 're2', '000.000.000-05', '2026-05-18'),
	(13, 'as', '1234', 'asda@gmail.com', '2026-04-26', 're2', '000.000.000-05', '2026-05-18'),
	(15, '22', '1234', 'wwe@gmail.com', '2026-04-26', 'rua machado', '000.000.000-04', '2026-06-09');

-- Copiando estrutura para tabela cassinoonline.usuario_conquista
DROP TABLE IF EXISTS `usuario_conquista`;
CREATE TABLE IF NOT EXISTS `usuario_conquista` (
  `id_usuarioConquista` int(11) NOT NULL AUTO_INCREMENT,
  `data_conquista` date DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_conquista` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuarioConquista`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_conquista` (`id_conquista`),
  CONSTRAINT `usuario_conquista_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `usuario_conquista_ibfk_2` FOREIGN KEY (`id_conquista`) REFERENCES `conquista` (`id_conquista`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela cassinoonline.usuario_conquista: ~1 rows (aproximadamente)
INSERT INTO `usuario_conquista` (`id_usuarioConquista`, `data_conquista`, `id_usuario`, `id_conquista`) VALUES
	(1, '2026-06-15', 12, 4);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

-- Tabela Usuario
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- Tabela Receita
CREATE TABLE Receita (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    data_recebimento DATE NOT NULL,
    fixa BOOLEAN NOT NULL,
    tipo_pagamento VARCHAR(50) NOT NULL,
    historico_id INT DEFAULT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

-- Tabela Despesa
CREATE TABLE Despesa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL,
    data_vencimento DATE NOT NULL,
    fixa BOOLEAN NOT NULL,
    parcela_unica BOOLEAN NOT NULL,
    numero_parcelas INT DEFAULT NULL,
    parcela_atual INT DEFAULT NULL,
    tipo_pagamento VARCHAR(50) NOT NULL,
    historico_id INT DEFAULT NULL,
    despesa_pai_id INT DEFAULT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (despesa_pai_id) REFERENCES Despesa(id)
);

-- Tabela HistoricoReceita
CREATE TABLE HistoricoReceita (
    id INT AUTO_INCREMENT PRIMARY KEY,
    receita_id INT NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    data_recebimento DATE NOT NULL,
    data_modificacao DATE NOT NULL,
    juros DECIMAL(10, 2) DEFAULT 0.00,
    multa DECIMAL(10, 2) DEFAULT 0.00,
    acrescimos DECIMAL(10, 2) DEFAULT 0.00,
    decrescimos DECIMAL(10, 2) DEFAULT 0.00,
    FOREIGN KEY (receita_id) REFERENCES Receita(id)
);

-- Tabela HistoricoDespesa
CREATE TABLE HistoricoDespesa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    despesa_id INT NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_modificacao DATE NOT NULL,
    juros DECIMAL(10, 2) DEFAULT 0.00,
    multa DECIMAL(10, 2) DEFAULT 0.00,
    acrescimos DECIMAL(10, 2) DEFAULT 0.00,
    decrescimos DECIMAL(10, 2) DEFAULT 0.00,
    FOREIGN KEY (despesa_id) REFERENCES Despesa(id)
);

-- Create `llms` table
CREATE TABLE llms (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      summary TEXT NOT NULL,
                      reference_link VARCHAR(255) NOT NULL
);

-- Create `llm_parameters` table
CREATE TABLE llm_parameters (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                llm_id INT NOT NULL,
                                version VARCHAR(50) NOT NULL,
                                parameters_count BIGINT NOT NULL,
                                FOREIGN KEY (llm_id) REFERENCES llms(id) ON DELETE CASCADE
);

-- Create `llm_performance` table
CREATE TABLE llm_performance (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 llm_id INT NOT NULL,
                                 version VARCHAR(50) NOT NULL,
                                 performance_metric FLOAT NOT NULL,
                                 FOREIGN KEY (llm_id) REFERENCES llms(id) ON DELETE CASCADE
);

-- Insert data into `llms` table
INSERT INTO llms (name, summary, reference_link) VALUES
('GPT-3', 'Generative model by OpenAI, known for advanced text generation.', 'https://openai.com/research/gpt-3'),
('BERT', 'Bidirectional Transformer by Google, effective for a variety of NLP tasks.', 'https://ai.google/research/bert'),
('T5', 'Text-to-Text Transfer Transformer by Google, versatile in text generation and translation tasks.', 'https://ai.google/research/transformer'),
('GPT-4', 'The successor of GPT-3 by OpenAI, with higher capacity and improved accuracy in understanding and generating language.', 'https://openai.com/research/gpt-4'),
('LaMDA', 'Language Model for Dialogue Applications by Google, designed for conversational AI.', 'https://ai.google/research/lamda');

-- Insert data into `llm_parameters` table
INSERT INTO llm_parameters (llm_id, version, parameters_count) VALUES
(1, 'GPT-3', 175000000000),
(2, 'BERT Base', 110000000),
(2, 'BERT Large', 340000000),
(3, 'T5 Small', 60000000),
(3, 'T5 Large', 11000000000),
(4, 'GPT-4', 1000000000000),
(5, 'LaMDA', 137000000000);

-- Insert data into `llm_performance` table
INSERT INTO llm_performance (llm_id, version, performance_metric) VALUES
(1, 'GPT-3', 92.7),
(2, 'BERT Base', 84.5),
(2, 'BERT Large', 87.1),
(3, 'T5 Small', 78.3),
(3, 'T5 Large', 90.2),
(4, 'GPT-4', 96.8),
(5, 'LaMDA', 94.1);
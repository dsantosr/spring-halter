INSERT INTO modalidades(nome) VALUES
('Musculacao'),
('Funcional'),
('Jiu-Jitsu'),
('Muay-Thai'),
('Pilates')
ON CONFLICT (nome) DO NOTHING;

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 120.00 FROM modalidades WHERE nome = 'Musculacao'
ON CONFLICT (modalidade_id, nome) DO NOTHING;

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Trimestral', 330.00 FROM modalidades WHERE nome = 'Musculacao'
ON CONFLICT (modalidade_id, nome) DO NOTHING;

INSERT INTO graduacoes(modalidade_id, nome)
SELECT id, 'Faixa Branca' FROM modalidades WHERE nome = 'Jiu-Jitsu'
ON CONFLICT (modalidade_id, nome) DO NOTHING;

INSERT INTO graduacoes(modalidade_id, nome)
SELECT id, 'Faixa Azul' FROM modalidades WHERE nome = 'Jiu-Jitsu'
ON CONFLICT (modalidade_id, nome) DO NOTHING;

INSERT INTO graduacoes(modalidade_id, nome)
SELECT id, 'Faixa Roxa' FROM modalidades WHERE nome = 'Jiu-Jitsu'
ON CONFLICT (modalidade_id, nome) DO NOTHING;

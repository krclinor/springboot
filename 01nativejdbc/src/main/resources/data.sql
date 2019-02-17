insert into singer(first_name, last_name, birth_date)
values
('John', 'Mayer', to_date('1977-10-16','yyyy-mm-dd')),
('Eric','Clapton', to_date('1945-03-30','yyyy-mm-dd')),
('John', 'Butler', to_date('1975-04-01','yyyy-mm-dd'));

insert into album(singer_id, title, release_date)
values
(1, 'The Search for Everything', to_date('20170120','yyyymmdd')),
(1, 'Battle Studies', to_date('20091117','yyyymmdd')),
(2, 'From The Cradle', to_date('19940913','yyyymmdd'));
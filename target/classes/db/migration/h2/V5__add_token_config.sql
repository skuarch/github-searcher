create table tokens (
    token_id bigserial not null,
    token_token text not null,
    constraint tokens primary key (token_id) 
);

insert into tokens (token_token) values ('NGYxOTU0N2FmNDY1N2Y2MzE2OTdmMzU2NWUzODZhZjk0YTkxMzA1YQ==');
insert into tokens (token_token) values ('NGQwYmI2ZWE3YTg2ZGVjNzI2NjE0ZDQzZTY5NTVkOTRmOWE2YjE1NA==');
insert into tokens (token_token) values ('NWRlNjFiM2FlYTU4ZTAzNTliYzk3ZmQyNzNhMTRhN2M1NGM4MjljYQ==');

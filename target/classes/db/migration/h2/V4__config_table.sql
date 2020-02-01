create table config (
    config_id bigserial not null,
    config_github_url character varying(512) not null,
    config_github_uri_search character varying(512) not null,
    config_github_uri_users character varying(512) not null,
    config_github_uri_repos character varying(512) not null,
    constraint config primary key (config_id)
);

insert into config (config_github_url, config_github_uri_search, config_github_uri_users, config_github_uri_repos) values ('https://api.github.com', '/search', '/users', '/repos');

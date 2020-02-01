create table github_user (
    github_user_id bigserial not null,
    github_user_first_name character varying(256) not null,    
    github_user_last_name character varying(256) not null,
    github_user_location character varying(512) not null,    
    github_user_last_modified character varying(19) not null,    
    github_user_last_pull character varying(19) not null,    
    constraint github_user primary key (github_user_id)
);

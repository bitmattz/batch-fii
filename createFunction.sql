select * from fiis order by random()

create function get_random_fii()
returns varchar
language plpgsql
as
$$
declare
   fii varchar;
begin
   select *
   into fii
   from fiis
   order by random();

   return fii;
end;
$$;

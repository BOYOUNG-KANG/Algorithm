-- 코드를 입력하세요
SELECT 
year(o.sales_date) year,
month(o.sales_date) month,
count(distinct o.user_id) puchased_users,
round(count(distinct o.user_id) / 
      (select count(*) from user_info 
       where year(joined) = '2021'), 1) PUCHASED_RATIO
from user_info u 
join online_sale o on u.user_id = o.user_id
where year(joined) = '2021'
group by year, month
order by year asc, month asc;
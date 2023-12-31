-- 코드를 입력하세요
# SELECT user_id, product_id from online_sale where sales_amount >= '2' order by user_id asc, product_id desc ;

select distinct a.user_id, a.product_id
from online_sale a 
join online_sale b on a.user_id = b.user_id and a.product_id = b.product_id 
where a.online_sale_id <> b.online_sale_id
order by a.user_id asc, a.product_id desc;

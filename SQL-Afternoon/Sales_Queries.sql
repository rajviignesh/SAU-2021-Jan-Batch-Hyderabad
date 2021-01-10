
-- Query 1: Write a query to retrieve the most sold product per day in a specific location (take any location) in last week
CREATE VIEW LAST_WEEK_SALES AS SELECT * FROM SALES WHERE DOP BETWEEN to_date('03-01-2021','dd-mm-yyyy') and to_date('10-01-2021','dd-mm-yyyy');

SELECT T.DOP AS Date_Of_Purchase, P.P_ID, P.P_NAME, max(ts) AS Max_Units from PRODUCT P
INNER JOIN
(SELECT sum(NOU) as ts, P_ID,DOP 
	FROM LAST_WEEK_SALES S,CUSTOMER C 
	WHERE C.LOCO_ID= 1 
	AND C.C_ID=S.C_ID 
    GROUP BY S.P_ID,S.DOP) T
ON T.P_ID=P.P_ID 
GROUP BY T.DOP,P.P_ID, P.P_NAME
ORDER BY T.DOP;

--Query 2: Write a query to list all the sales persons details along with the count of products sold by them (if any) till current date 

SELECT SE.*, NVL(T.ps, 0) AS Products_Sold, NVL(T.nus, 0) AS Units_Sold FROM SALES_EXE SE
LEFT JOIN
(SELECT SE_ID, COUNT(DISTINCT P_ID) ps, SUM(NOU) AS nus FROM SALES GROUP BY SE_ID) T
ON T.SE_ID=SE.SE_ID;
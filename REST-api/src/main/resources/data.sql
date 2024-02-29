insert into booking_details(booking_date,booking_number,number_of_seats,bus_number,destination,source,status)
values(current_date(),101,25,'MH2000','Pune','Khed','Available');

insert into booking_details(booking_date,booking_number,number_of_seats,bus_number,destination,source,status)
values(current_date(),102,25,'MH2000','Pune1','Khed1','Not Available');

insert into passenger(booking_number,id,name)
values(101,1001,'Abhishek');

insert into passenger(booking_number,id,name)
values(102,1002,'Shubham');
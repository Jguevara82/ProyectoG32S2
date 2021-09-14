create database bd_tiendagenerica;
create table usuarios(
cedula_usuario bigint primary key,
email_usuario varchar(255),
nombre_usuario varchar(255),
password varchar(255),
usuario varchar(255)
);

create table clientes(
cedula_cliente bigint primary key,
direccion_cliente varchar(255),
email_cliente varchar(255),
nombre_cliente varchar(255),
telefono_cliente varchar(255)
);

create table ventas(
codigo_venta bigint primary key,
cedula_cliente bigint not null,
cedula_usuario bigint not null,
ivaventa double not null,
total_venta double not null,
valor_venta double not null,
foreign key (cedula_usuario) references usuarios (cedula_usuario),
foreign key (cedula_cliente) references clientes (cedula_cliente)
);

create table proveedores(
nitproveedor bigint primary key,
ciudad_proveedor varchar(255),
direccion_proveedor varchar(255),
nombre_proveedor varchar(255),
telefono_proveedor varchar(255)
);

create table productos(
codigo_producto bigint primary key,
ivacompra double not null,
nitproveedor bigint not null,
nombre_producto varchar(255),
precio_compra double not null,
precio_venta double not null,
foreign key (nitproveedor) references proveedores (nitproveedor)
);

create table detalle_ventas(
codigo_detalle_venta bigint primary key,
cantidad_producto int(11) not null,
codigo_producto bigint not null,
codigo_venta bigint not null,
valor_total double not null,
valor_venta double not null,
valoriva double not null,
foreign key (codigo_venta) references ventas (codigo_venta),
foreign key (codigo_producto) references productos (codigo_producto)
);
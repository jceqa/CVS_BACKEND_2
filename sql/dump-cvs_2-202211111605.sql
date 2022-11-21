--
-- PostgreSQL database dump
--

-- Dumped from database version 12.12 (Ubuntu 12.12-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.12 (Ubuntu 12.12-0ubuntu0.20.04.1)

-- Started on 2022-11-11 16:05:29 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 737820)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 4092 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 356 (class 1255 OID 737821)
-- Name: calcular_total_presupuesto(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.calcular_total_presupuesto() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
	BEGIN
		UPDATE presupuestos SET presu_total = (presu_total + (NEW.cant_presu * NEW.precio_presu)) WHERE presupuestos.presu_id = NEW.presu_id;
		RETURN new;
	END;
$$;


ALTER FUNCTION public.calcular_total_presupuesto() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 737822)
-- Name: ajuste; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ajuste (
    id integer NOT NULL,
    cantidad integer,
    descripcion character varying(255),
    estado character varying(255),
    fecha timestamp without time zone,
    tipo character varying(255),
    id_stock integer,
    id_estado integer
);


ALTER TABLE public.ajuste OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 737828)
-- Name: ajuste_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ajuste_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ajuste_id_seq OWNER TO postgres;

--
-- TOC entry 4093 (class 0 OID 0)
-- Dependencies: 203
-- Name: ajuste_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ajuste_id_seq OWNED BY public.ajuste.id;


--
-- TOC entry 204 (class 1259 OID 737830)
-- Name: apertura_cierre_caja; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.apertura_cierre_caja (
    id integer NOT NULL,
    descripcion character varying(255),
    estado character varying(255),
    fecha_hora_apertura timestamp without time zone,
    fecha_hora_cierre timestamp without time zone,
    monto_apertura bigint,
    monto_cierre bigint,
    monto_cierre_cheque bigint,
    monto_cierre_efectivo bigint,
    monto_cierre_tarjeta bigint,
    id_caja integer,
    id_usuario integer
);


ALTER TABLE public.apertura_cierre_caja OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 737836)
-- Name: apertura_cierre_caja_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.apertura_cierre_caja_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.apertura_cierre_caja_id_seq OWNER TO postgres;

--
-- TOC entry 4094 (class 0 OID 0)
-- Dependencies: 205
-- Name: apertura_cierre_caja_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.apertura_cierre_caja_id_seq OWNED BY public.apertura_cierre_caja.id;


--
-- TOC entry 206 (class 1259 OID 737838)
-- Name: articulo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.articulo (
    id integer NOT NULL,
    descripcion character varying NOT NULL,
    precio_compra bigint NOT NULL,
    precio_venta bigint NOT NULL,
    codigo_generico character varying NOT NULL,
    id_impuesto integer NOT NULL,
    id_marca integer NOT NULL,
    id_tipo_articulo integer NOT NULL,
    estado character varying,
    precio_compra_anterior bigint,
    precio_venta_anterior bigint
);


ALTER TABLE public.articulo OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 737844)
-- Name: articulo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.articulo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.articulo_id_seq OWNER TO postgres;

--
-- TOC entry 4095 (class 0 OID 0)
-- Dependencies: 207
-- Name: articulo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.articulo_id_seq OWNED BY public.articulo.id;


--
-- TOC entry 208 (class 1259 OID 737846)
-- Name: banco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.banco (
    id integer NOT NULL,
    descripcion character varying(200) NOT NULL,
    estado character varying
);


ALTER TABLE public.banco OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 737852)
-- Name: banco_banco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.banco_banco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.banco_banco_id_seq OWNER TO postgres;

--
-- TOC entry 4096 (class 0 OID 0)
-- Dependencies: 209
-- Name: banco_banco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.banco_banco_id_seq OWNED BY public.banco.id;


--
-- TOC entry 210 (class 1259 OID 737854)
-- Name: banco_cheque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.banco_cheque (
    id integer NOT NULL,
    descripcion character varying,
    estado character varying
);


ALTER TABLE public.banco_cheque OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 737860)
-- Name: banco_cheque_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.banco_cheque_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.banco_cheque_id_seq OWNER TO postgres;

--
-- TOC entry 4097 (class 0 OID 0)
-- Dependencies: 211
-- Name: banco_cheque_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.banco_cheque_id_seq OWNED BY public.banco_cheque.id;


--
-- TOC entry 212 (class 1259 OID 737862)
-- Name: caja; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caja (
    id integer NOT NULL,
    descripcion character varying(90) NOT NULL,
    numero integer NOT NULL,
    estado character varying,
    id_sucursal integer
);


ALTER TABLE public.caja OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 737868)
-- Name: caja_caja_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.caja_caja_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.caja_caja_id_seq OWNER TO postgres;

--
-- TOC entry 4098 (class 0 OID 0)
-- Dependencies: 213
-- Name: caja_caja_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.caja_caja_id_seq OWNED BY public.caja.id;


--
-- TOC entry 214 (class 1259 OID 737870)
-- Name: cargo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cargo (
    id integer NOT NULL,
    descripcion character varying,
    estado character varying
);


ALTER TABLE public.cargo OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 737876)
-- Name: cargo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cargo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cargo_id_seq OWNER TO postgres;

--
-- TOC entry 4099 (class 0 OID 0)
-- Dependencies: 215
-- Name: cargo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cargo_id_seq OWNED BY public.cargo.id;


--
-- TOC entry 216 (class 1259 OID 737878)
-- Name: ciudad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ciudad (
    id integer NOT NULL,
    descripcion character varying,
    estado character varying
);


ALTER TABLE public.ciudad OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 737884)
-- Name: ciudad_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ciudad_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ciudad_id_seq OWNER TO postgres;

--
-- TOC entry 4100 (class 0 OID 0)
-- Dependencies: 217
-- Name: ciudad_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ciudad_id_seq OWNED BY public.ciudad.id;


--
-- TOC entry 218 (class 1259 OID 737886)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id integer NOT NULL,
    correo character varying(255),
    direccion character varying(255),
    estado character varying(255),
    razon character varying(255),
    ruc character varying(255),
    telefono character varying(255),
    id_ciudad integer
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 737892)
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_seq OWNER TO postgres;

--
-- TOC entry 4101 (class 0 OID 0)
-- Dependencies: 219
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;


--
-- TOC entry 220 (class 1259 OID 737894)
-- Name: cobro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cobro (
    id integer NOT NULL,
    descripcion character varying(255),
    estado character varying(255),
    fecha timestamp without time zone,
    monto bigint
);


ALTER TABLE public.cobro OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 737900)
-- Name: cobro_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cobro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cobro_id_seq OWNER TO postgres;

--
-- TOC entry 4102 (class 0 OID 0)
-- Dependencies: 221
-- Name: cobro_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cobro_id_seq OWNED BY public.cobro.id;


--
-- TOC entry 222 (class 1259 OID 737902)
-- Name: condicion_pago; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.condicion_pago (
    id integer NOT NULL,
    descripcion character varying,
    estado character varying
);


ALTER TABLE public.condicion_pago OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 737908)
-- Name: condicion_pago_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.condicion_pago_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.condicion_pago_id_seq OWNER TO postgres;

--
-- TOC entry 4103 (class 0 OID 0)
-- Dependencies: 223
-- Name: condicion_pago_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.condicion_pago_id_seq OWNED BY public.condicion_pago.id;


--
-- TOC entry 224 (class 1259 OID 737910)
-- Name: cuenta_a_cobrar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cuenta_a_cobrar (
    id integer NOT NULL,
    cantidad_cuotas integer,
    estado character varying(255),
    fecha_vencimiento timestamp without time zone,
    monto bigint,
    numero_cuota integer,
    id_cobro integer,
    id_estado integer,
    id_factura integer
);


ALTER TABLE public.cuenta_a_cobrar OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 737913)
-- Name: cuenta_a_cobrar_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cuenta_a_cobrar_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cuenta_a_cobrar_id_seq OWNER TO postgres;

--
-- TOC entry 4104 (class 0 OID 0)
-- Dependencies: 225
-- Name: cuenta_a_cobrar_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cuenta_a_cobrar_id_seq OWNED BY public.cuenta_a_cobrar.id;


--
-- TOC entry 226 (class 1259 OID 737915)
-- Name: cuenta_a_pagar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cuenta_a_pagar (
    id integer NOT NULL,
    cantidad_cuotas integer,
    estado character varying(255),
    fecha_vencimiento timestamp without time zone,
    monto bigint,
    numero_cuota integer,
    id_estado integer,
    id_pago integer
);


ALTER TABLE public.cuenta_a_pagar OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 737918)
-- Name: cuenta_a_pagar_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cuenta_a_pagar_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cuenta_a_pagar_id_seq OWNER TO postgres;

--
-- TOC entry 4105 (class 0 OID 0)
-- Dependencies: 227
-- Name: cuenta_a_pagar_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cuenta_a_pagar_id_seq OWNED BY public.cuenta_a_pagar.id;


--
-- TOC entry 228 (class 1259 OID 737920)
-- Name: deposito_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.deposito_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.deposito_id_seq OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 737922)
-- Name: deposito; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.deposito (
    id integer DEFAULT nextval('public.deposito_id_seq'::regclass) NOT NULL,
    descripcion character varying,
    id_sucursal integer,
    estado character varying
);


ALTER TABLE public.deposito OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 737929)
-- Name: pedido_compra_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_compra_detalle (
    id integer NOT NULL,
    cantidad integer,
    estado character varying(255),
    id_articulo integer,
    id_pedido_compra integer
);


ALTER TABLE public.pedido_compra_detalle OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 737932)
-- Name: detalle_pedido_compra_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detalle_pedido_compra_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalle_pedido_compra_id_seq OWNER TO postgres;

--
-- TOC entry 4106 (class 0 OID 0)
-- Dependencies: 231
-- Name: detalle_pedido_compra_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detalle_pedido_compra_id_seq OWNED BY public.pedido_compra_detalle.id;


--
-- TOC entry 232 (class 1259 OID 737934)
-- Name: diagnostico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.diagnostico (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    observacion character varying(255),
    id_estado integer,
    id_recepcion integer,
    id_usuario integer
);


ALTER TABLE public.diagnostico OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 737940)
-- Name: diagnostico_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.diagnostico_detalle (
    id integer NOT NULL,
    diagnostico character varying(255),
    estado character varying(255),
    id_recepcion_detalle integer,
    id_diagnostico integer,
    id_servicio integer
);


ALTER TABLE public.diagnostico_detalle OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 737946)
-- Name: diagnostico_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.diagnostico_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.diagnostico_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4107 (class 0 OID 0)
-- Dependencies: 234
-- Name: diagnostico_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.diagnostico_detalle_id_seq OWNED BY public.diagnostico_detalle.id;


--
-- TOC entry 235 (class 1259 OID 737948)
-- Name: diagnostico_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.diagnostico_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.diagnostico_id_seq OWNER TO postgres;

--
-- TOC entry 4108 (class 0 OID 0)
-- Dependencies: 235
-- Name: diagnostico_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.diagnostico_id_seq OWNED BY public.diagnostico.id;


--
-- TOC entry 236 (class 1259 OID 737950)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persona (
    id integer NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    ci character varying NOT NULL,
    telefono character varying NOT NULL,
    direccion character varying NOT NULL,
    id_ciudad integer NOT NULL,
    estado character varying
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 737956)
-- Name: empleado_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.empleado_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.empleado_id_seq OWNER TO postgres;

--
-- TOC entry 4109 (class 0 OID 0)
-- Dependencies: 237
-- Name: empleado_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.empleado_id_seq OWNED BY public.persona.id;


--
-- TOC entry 238 (class 1259 OID 737958)
-- Name: empresa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empresa (
    id integer NOT NULL,
    telefono character varying(80) NOT NULL,
    direccion character varying(150) NOT NULL,
    nombre character varying(70) NOT NULL,
    ruc character varying(20) NOT NULL,
    estado character varying
);


ALTER TABLE public.empresa OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 737964)
-- Name: empresa_empre_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.empresa_empre_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.empresa_empre_id_seq OWNER TO postgres;

--
-- TOC entry 4110 (class 0 OID 0)
-- Dependencies: 239
-- Name: empresa_empre_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.empresa_empre_id_seq OWNED BY public.empresa.id;


--
-- TOC entry 240 (class 1259 OID 737966)
-- Name: encargado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.encargado (
    id integer NOT NULL,
    id_sucursal integer NOT NULL,
    nombre character varying(60) NOT NULL,
    apellido character varying(60) NOT NULL,
    direccion character varying(60) NOT NULL,
    telefono character varying(60) NOT NULL,
    email character varying(60) NOT NULL
);


ALTER TABLE public.encargado OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 737969)
-- Name: encargado_enca_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.encargado_enca_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.encargado_enca_id_seq OWNER TO postgres;

--
-- TOC entry 4111 (class 0 OID 0)
-- Dependencies: 241
-- Name: encargado_enca_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.encargado_enca_id_seq OWNED BY public.encargado.id;


--
-- TOC entry 242 (class 1259 OID 737971)
-- Name: entidad_emisora; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entidad_emisora (
    id integer NOT NULL,
    descripcion character varying,
    estado character varying
);


ALTER TABLE public.entidad_emisora OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 737977)
-- Name: entidad_emisora_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.entidad_emisora_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.entidad_emisora_id_seq OWNER TO postgres;

--
-- TOC entry 4112 (class 0 OID 0)
-- Dependencies: 243
-- Name: entidad_emisora_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.entidad_emisora_id_seq OWNED BY public.entidad_emisora.id;


--
-- TOC entry 244 (class 1259 OID 737979)
-- Name: equipo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipo (
    id integer NOT NULL,
    serie character varying NOT NULL,
    descripcion character varying NOT NULL,
    modelo character varying(60) NOT NULL,
    id_marca integer NOT NULL,
    estado character varying,
    id_cliente integer
);


ALTER TABLE public.equipo OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 737985)
-- Name: equipos_equi_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.equipos_equi_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipos_equi_id_seq OWNER TO postgres;

--
-- TOC entry 4113 (class 0 OID 0)
-- Dependencies: 245
-- Name: equipos_equi_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.equipos_equi_id_seq OWNED BY public.equipo.id;


--
-- TOC entry 246 (class 1259 OID 737987)
-- Name: estado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado (
    id integer NOT NULL,
    descripcion character varying,
    estado character varying
);


ALTER TABLE public.estado OWNER TO postgres;

--
-- TOC entry 247 (class 1259 OID 737993)
-- Name: estado_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estado_id_seq OWNER TO postgres;

--
-- TOC entry 4114 (class 0 OID 0)
-- Dependencies: 247
-- Name: estado_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_id_seq OWNED BY public.estado.id;


--
-- TOC entry 248 (class 1259 OID 737995)
-- Name: factura; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.factura (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    monto bigint,
    numerofactura character varying(255),
    observacion character varying(255),
    id_caja integer,
    id_condicion_pago integer,
    id_estado integer,
    id_libro_venta integer,
    id_pedido_venta integer,
    id_timbrado integer,
    id_usuario integer
);


ALTER TABLE public.factura OWNER TO postgres;

--
-- TOC entry 249 (class 1259 OID 738001)
-- Name: factura_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.factura_compra (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    monto bigint,
    numero_factura character varying(255),
    observacion character varying(255),
    id_estado integer,
    id_libro_compra integer,
    id_orden_compra integer,
    id_usuario integer
);


ALTER TABLE public.factura_compra OWNER TO postgres;

--
-- TOC entry 250 (class 1259 OID 738007)
-- Name: factura_compra_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.factura_compra_detalle (
    id integer NOT NULL,
    estado character varying(255),
    id_orden_compra_detalle integer,
    id_factura_compra integer
);


ALTER TABLE public.factura_compra_detalle OWNER TO postgres;

--
-- TOC entry 251 (class 1259 OID 738010)
-- Name: factura_compra_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.factura_compra_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.factura_compra_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4115 (class 0 OID 0)
-- Dependencies: 251
-- Name: factura_compra_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.factura_compra_detalle_id_seq OWNED BY public.factura_compra_detalle.id;


--
-- TOC entry 252 (class 1259 OID 738012)
-- Name: factura_compra_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.factura_compra_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.factura_compra_id_seq OWNER TO postgres;

--
-- TOC entry 4116 (class 0 OID 0)
-- Dependencies: 252
-- Name: factura_compra_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.factura_compra_id_seq OWNED BY public.factura_compra.id;


--
-- TOC entry 253 (class 1259 OID 738014)
-- Name: factura_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.factura_detalle (
    id integer NOT NULL,
    estado character varying(255),
    monto bigint,
    id_oreden_servicio_detalle integer,
    id_pedido_venta_detalle integer,
    id_factura integer
);


ALTER TABLE public.factura_detalle OWNER TO postgres;

--
-- TOC entry 254 (class 1259 OID 738017)
-- Name: factura_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.factura_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.factura_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4117 (class 0 OID 0)
-- Dependencies: 254
-- Name: factura_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.factura_detalle_id_seq OWNED BY public.factura_detalle.id;


--
-- TOC entry 255 (class 1259 OID 738019)
-- Name: factura_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.factura_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.factura_id_seq OWNER TO postgres;

--
-- TOC entry 4118 (class 0 OID 0)
-- Dependencies: 255
-- Name: factura_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.factura_id_seq OWNED BY public.factura.id;


--
-- TOC entry 256 (class 1259 OID 738021)
-- Name: forma_cobro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.forma_cobro (
    id integer NOT NULL,
    descripcion character varying(40) NOT NULL,
    estado character varying
);


ALTER TABLE public.forma_cobro OWNER TO postgres;

--
-- TOC entry 257 (class 1259 OID 738027)
-- Name: forma_cobro_form_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.forma_cobro_form_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.forma_cobro_form_id_seq OWNER TO postgres;

--
-- TOC entry 4119 (class 0 OID 0)
-- Dependencies: 257
-- Name: forma_cobro_form_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.forma_cobro_form_id_seq OWNED BY public.forma_cobro.id;


--
-- TOC entry 258 (class 1259 OID 738029)
-- Name: formulario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.formulario (
    id integer NOT NULL,
    nombre character varying,
    url character varying,
    id_sistema integer,
    id_sub_menu integer,
    id_usuario_auditoria integer,
    estado character varying
);


ALTER TABLE public.formulario OWNER TO postgres;

--
-- TOC entry 259 (class 1259 OID 738035)
-- Name: formularios_id_formulario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.formularios_id_formulario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.formularios_id_formulario_seq OWNER TO postgres;

--
-- TOC entry 4120 (class 0 OID 0)
-- Dependencies: 259
-- Name: formularios_id_formulario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.formularios_id_formulario_seq OWNED BY public.formulario.id;


--
-- TOC entry 260 (class 1259 OID 738037)
-- Name: impuesto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.impuesto (
    id integer NOT NULL,
    descripcion character varying,
    estado character varying,
    porcentaje_impuesto integer
);


ALTER TABLE public.impuesto OWNER TO postgres;

--
-- TOC entry 261 (class 1259 OID 738043)
-- Name: impuesto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.impuesto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.impuesto_id_seq OWNER TO postgres;

--
-- TOC entry 4121 (class 0 OID 0)
-- Dependencies: 261
-- Name: impuesto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.impuesto_id_seq OWNED BY public.impuesto.id;


--
-- TOC entry 262 (class 1259 OID 738045)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item (
    id integer NOT NULL,
    descripcion character varying(200) NOT NULL,
    precio integer NOT NULL,
    stock integer NOT NULL,
    id_marca integer NOT NULL,
    estado character varying
);


ALTER TABLE public.item OWNER TO postgres;

--
-- TOC entry 263 (class 1259 OID 738051)
-- Name: items_item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.items_item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.items_item_id_seq OWNER TO postgres;

--
-- TOC entry 4122 (class 0 OID 0)
-- Dependencies: 263
-- Name: items_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.items_item_id_seq OWNED BY public.item.id;


--
-- TOC entry 264 (class 1259 OID 738053)
-- Name: libro_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_compra (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    monto_iva_10 bigint,
    monto_iva_5 bigint,
    montoneto bigint
);


ALTER TABLE public.libro_compra OWNER TO postgres;

--
-- TOC entry 265 (class 1259 OID 738056)
-- Name: libro_compra_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_compra_detalle (
    id integer NOT NULL,
    estado character varying(255),
    monto_impuesto bigint,
    monto_neto bigint,
    id_factura_compra_detalle integer,
    id_impuesto integer,
    id_libro_compra integer
);


ALTER TABLE public.libro_compra_detalle OWNER TO postgres;

--
-- TOC entry 266 (class 1259 OID 738059)
-- Name: libro_compra_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.libro_compra_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.libro_compra_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4123 (class 0 OID 0)
-- Dependencies: 266
-- Name: libro_compra_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.libro_compra_detalle_id_seq OWNED BY public.libro_compra_detalle.id;


--
-- TOC entry 267 (class 1259 OID 738061)
-- Name: libro_compra_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.libro_compra_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.libro_compra_id_seq OWNER TO postgres;

--
-- TOC entry 4124 (class 0 OID 0)
-- Dependencies: 267
-- Name: libro_compra_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.libro_compra_id_seq OWNED BY public.libro_compra.id;


--
-- TOC entry 268 (class 1259 OID 738063)
-- Name: libro_venta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_venta (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    monto_iva_10 bigint,
    monto_iva_5 bigint,
    montoneto bigint
);


ALTER TABLE public.libro_venta OWNER TO postgres;

--
-- TOC entry 269 (class 1259 OID 738066)
-- Name: libro_venta_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_venta_detalle (
    id integer NOT NULL,
    estado character varying(255),
    monto_impuesto bigint,
    monto_neto bigint,
    id_factura_detalle integer,
    id_impuesto integer,
    id_libro_venta integer
);


ALTER TABLE public.libro_venta_detalle OWNER TO postgres;

--
-- TOC entry 270 (class 1259 OID 738069)
-- Name: libro_venta_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.libro_venta_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.libro_venta_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4125 (class 0 OID 0)
-- Dependencies: 270
-- Name: libro_venta_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.libro_venta_detalle_id_seq OWNED BY public.libro_venta_detalle.id;


--
-- TOC entry 271 (class 1259 OID 738071)
-- Name: libro_venta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.libro_venta_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.libro_venta_id_seq OWNER TO postgres;

--
-- TOC entry 4126 (class 0 OID 0)
-- Dependencies: 271
-- Name: libro_venta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.libro_venta_id_seq OWNED BY public.libro_venta.id;


--
-- TOC entry 272 (class 1259 OID 738073)
-- Name: marca; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marca (
    id integer NOT NULL,
    descripcion character varying(60) NOT NULL,
    estado character varying
);


ALTER TABLE public.marca OWNER TO postgres;

--
-- TOC entry 273 (class 1259 OID 738079)
-- Name: marcas_mar_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.marcas_mar_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marcas_mar_id_seq OWNER TO postgres;

--
-- TOC entry 4127 (class 0 OID 0)
-- Dependencies: 273
-- Name: marcas_mar_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.marcas_mar_id_seq OWNED BY public.marca.id;


--
-- TOC entry 274 (class 1259 OID 738081)
-- Name: motivo_ajuste; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.motivo_ajuste (
    id integer NOT NULL,
    descripcion character varying(100) NOT NULL,
    estado character varying
);


ALTER TABLE public.motivo_ajuste OWNER TO postgres;

--
-- TOC entry 275 (class 1259 OID 738087)
-- Name: motivo_ajuste_maju_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.motivo_ajuste_maju_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.motivo_ajuste_maju_id_seq OWNER TO postgres;

--
-- TOC entry 4128 (class 0 OID 0)
-- Dependencies: 275
-- Name: motivo_ajuste_maju_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.motivo_ajuste_maju_id_seq OWNED BY public.motivo_ajuste.id;


--
-- TOC entry 276 (class 1259 OID 738089)
-- Name: nota_credito_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nota_credito_compra (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    monto bigint,
    observacion character varying(255),
    id_estado integer,
    id_factura_compra integer,
    id_proveedor integer,
    id_orden_compra_cancelacion integer,
    id_usuario integer
);


ALTER TABLE public.nota_credito_compra OWNER TO postgres;

--
-- TOC entry 277 (class 1259 OID 738095)
-- Name: nota_credito_compra_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nota_credito_compra_detalle (
    id integer NOT NULL,
    cantidad integer,
    estado character varying(255),
    monto bigint,
    id_articulo integer,
    id_nota_credito_compra integer
);


ALTER TABLE public.nota_credito_compra_detalle OWNER TO postgres;

--
-- TOC entry 278 (class 1259 OID 738098)
-- Name: nota_credito_compra_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nota_credito_compra_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nota_credito_compra_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4129 (class 0 OID 0)
-- Dependencies: 278
-- Name: nota_credito_compra_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nota_credito_compra_detalle_id_seq OWNED BY public.nota_credito_compra_detalle.id;


--
-- TOC entry 279 (class 1259 OID 738100)
-- Name: nota_credito_compra_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nota_credito_compra_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nota_credito_compra_id_seq OWNER TO postgres;

--
-- TOC entry 4130 (class 0 OID 0)
-- Dependencies: 279
-- Name: nota_credito_compra_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nota_credito_compra_id_seq OWNED BY public.nota_credito_compra.id;


--
-- TOC entry 280 (class 1259 OID 738102)
-- Name: nota_debito_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nota_debito_compra (
    id integer NOT NULL,
    estado character varying(255),
    monto bigint,
    numero character varying(255),
    observacion character varying(255),
    id_cuenta_a_pagar integer,
    id_estado integer,
    id_factura_compra integer
);


ALTER TABLE public.nota_debito_compra OWNER TO postgres;

--
-- TOC entry 281 (class 1259 OID 738108)
-- Name: nota_debito_compra_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nota_debito_compra_detalle (
    id integer NOT NULL,
    estado character varying(255),
    id_factura_compra_detalle integer,
    id_nota_debito integer
);


ALTER TABLE public.nota_debito_compra_detalle OWNER TO postgres;

--
-- TOC entry 282 (class 1259 OID 738111)
-- Name: nota_debito_compra_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nota_debito_compra_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nota_debito_compra_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4131 (class 0 OID 0)
-- Dependencies: 282
-- Name: nota_debito_compra_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nota_debito_compra_detalle_id_seq OWNED BY public.nota_debito_compra_detalle.id;


--
-- TOC entry 283 (class 1259 OID 738113)
-- Name: nota_debito_compra_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nota_debito_compra_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nota_debito_compra_id_seq OWNER TO postgres;

--
-- TOC entry 4132 (class 0 OID 0)
-- Dependencies: 283
-- Name: nota_debito_compra_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nota_debito_compra_id_seq OWNED BY public.nota_debito_compra.id;


--
-- TOC entry 284 (class 1259 OID 738115)
-- Name: nota_remision; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nota_remision (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    observacion character varying(255),
    tipo character varying(255),
    id_destino integer,
    id_estado integer,
    id_origen integer,
    id_pedido_compra integer,
    id_factura_compra integer,
    id_usuario integer
);


ALTER TABLE public.nota_remision OWNER TO postgres;

--
-- TOC entry 285 (class 1259 OID 738121)
-- Name: nota_remision_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nota_remision_detalle (
    id integer NOT NULL,
    cantidad integer,
    estado character varying(255),
    id_articulo integer,
    id_pedido_compra_detalle integer,
    id_nota_remision integer
);


ALTER TABLE public.nota_remision_detalle OWNER TO postgres;

--
-- TOC entry 286 (class 1259 OID 738124)
-- Name: nota_remision_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nota_remision_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nota_remision_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4133 (class 0 OID 0)
-- Dependencies: 286
-- Name: nota_remision_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nota_remision_detalle_id_seq OWNED BY public.nota_remision_detalle.id;


--
-- TOC entry 287 (class 1259 OID 738126)
-- Name: nota_remision_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nota_remision_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nota_remision_id_seq OWNER TO postgres;

--
-- TOC entry 4134 (class 0 OID 0)
-- Dependencies: 287
-- Name: nota_remision_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nota_remision_id_seq OWNED BY public.nota_remision.id;


--
-- TOC entry 288 (class 1259 OID 738128)
-- Name: orden_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orden_compra (
    id integer NOT NULL,
    cantidad_cuota integer,
    estado character varying(255),
    fecha timestamp without time zone,
    intervalo integer,
    monto bigint,
    monto_cuota bigint,
    observacion character varying(255),
    id_condicion_pago integer,
    id_estado integer,
    id_proveedor integer,
    id_usuario integer
);


ALTER TABLE public.orden_compra OWNER TO postgres;

--
-- TOC entry 289 (class 1259 OID 738134)
-- Name: orden_compra_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orden_compra_detalle (
    id integer NOT NULL,
    estado character varying(255),
    monto bigint,
    id_presupueto_compra_detalle integer,
    id_orden_compra integer
);


ALTER TABLE public.orden_compra_detalle OWNER TO postgres;

--
-- TOC entry 290 (class 1259 OID 738137)
-- Name: orden_compra_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_compra_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_compra_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4135 (class 0 OID 0)
-- Dependencies: 290
-- Name: orden_compra_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_compra_detalle_id_seq OWNED BY public.orden_compra_detalle.id;


--
-- TOC entry 291 (class 1259 OID 738139)
-- Name: orden_compra_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_compra_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_compra_id_seq OWNER TO postgres;

--
-- TOC entry 4136 (class 0 OID 0)
-- Dependencies: 291
-- Name: orden_compra_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_compra_id_seq OWNED BY public.orden_compra.id;


--
-- TOC entry 292 (class 1259 OID 738141)
-- Name: orden_servicio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orden_servicio (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    fecha_entrega timestamp without time zone,
    observacion character varying(255),
    total bigint,
    vencimiento_garantia timestamp without time zone,
    id_estado integer,
    id_presupuesto_servicio integer,
    id_usuario integer,
    id_factura integer
);


ALTER TABLE public.orden_servicio OWNER TO postgres;

--
-- TOC entry 293 (class 1259 OID 738147)
-- Name: orden_servicio_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orden_servicio_detalle (
    id integer NOT NULL,
    estado character varying(255),
    monto bigint,
    id_presupueto_servicio_detalle integer,
    id_orden_servicio integer
);


ALTER TABLE public.orden_servicio_detalle OWNER TO postgres;

--
-- TOC entry 294 (class 1259 OID 738150)
-- Name: orden_servicio_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_servicio_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_servicio_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4137 (class 0 OID 0)
-- Dependencies: 294
-- Name: orden_servicio_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_servicio_detalle_id_seq OWNED BY public.orden_servicio_detalle.id;


--
-- TOC entry 295 (class 1259 OID 738152)
-- Name: orden_servicio_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_servicio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_servicio_id_seq OWNER TO postgres;

--
-- TOC entry 4138 (class 0 OID 0)
-- Dependencies: 295
-- Name: orden_servicio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_servicio_id_seq OWNED BY public.orden_servicio.id;


--
-- TOC entry 296 (class 1259 OID 738154)
-- Name: pago; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pago (
    id integer NOT NULL,
    descripcion character varying(255),
    estado character varying(255),
    fecha timestamp without time zone,
    monto bigint
);


ALTER TABLE public.pago OWNER TO postgres;

--
-- TOC entry 297 (class 1259 OID 738160)
-- Name: pago_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pago_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pago_id_seq OWNER TO postgres;

--
-- TOC entry 4139 (class 0 OID 0)
-- Dependencies: 297
-- Name: pago_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pago_id_seq OWNED BY public.pago.id;


--
-- TOC entry 298 (class 1259 OID 738162)
-- Name: pedido_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_compra (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    id_deposito integer,
    id_estado integer,
    id_usuario integer,
    observacion character varying
);


ALTER TABLE public.pedido_compra OWNER TO postgres;

--
-- TOC entry 299 (class 1259 OID 738168)
-- Name: pedido_compra_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_compra_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_compra_id_seq OWNER TO postgres;

--
-- TOC entry 4140 (class 0 OID 0)
-- Dependencies: 299
-- Name: pedido_compra_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedido_compra_id_seq OWNED BY public.pedido_compra.id;


--
-- TOC entry 300 (class 1259 OID 738170)
-- Name: pedido_venta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_venta (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    observacion character varying(255),
    id_deposito integer,
    id_estado integer,
    id_usuario integer,
    id_cliente integer
);


ALTER TABLE public.pedido_venta OWNER TO postgres;

--
-- TOC entry 301 (class 1259 OID 738176)
-- Name: pedido_venta_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_venta_detalle (
    id integer NOT NULL,
    cantidad integer,
    estado character varying(255),
    id_articulo integer,
    id_pedido_venta integer
);


ALTER TABLE public.pedido_venta_detalle OWNER TO postgres;

--
-- TOC entry 302 (class 1259 OID 738179)
-- Name: pedido_venta_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_venta_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_venta_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4141 (class 0 OID 0)
-- Dependencies: 302
-- Name: pedido_venta_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedido_venta_detalle_id_seq OWNED BY public.pedido_venta_detalle.id;


--
-- TOC entry 303 (class 1259 OID 738181)
-- Name: pedido_venta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_venta_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_venta_id_seq OWNER TO postgres;

--
-- TOC entry 4142 (class 0 OID 0)
-- Dependencies: 303
-- Name: pedido_venta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedido_venta_id_seq OWNED BY public.pedido_venta.id;


--
-- TOC entry 304 (class 1259 OID 738183)
-- Name: permiso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permiso (
    id integer NOT NULL,
    id_rol integer,
    id_formulario integer,
    agregar boolean,
    modificar boolean,
    eliminar boolean,
    consultar boolean,
    listar boolean,
    informe boolean,
    exportar boolean,
    id_usuario_auditoria integer,
    estado character varying,
    reactivar boolean,
    anular boolean
);


ALTER TABLE public.permiso OWNER TO postgres;

--
-- TOC entry 305 (class 1259 OID 738189)
-- Name: permisos_id_permiso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.permisos_id_permiso_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.permisos_id_permiso_seq OWNER TO postgres;

--
-- TOC entry 4143 (class 0 OID 0)
-- Dependencies: 305
-- Name: permisos_id_permiso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.permisos_id_permiso_seq OWNED BY public.permiso.id;


--
-- TOC entry 306 (class 1259 OID 738191)
-- Name: presupuesto_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.presupuesto_compra (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    observacion character varying(255),
    total bigint,
    id_estado integer,
    id_pedido_compra integer,
    id_usuario integer,
    id_proveedor integer,
    id_orden_compra integer
);


ALTER TABLE public.presupuesto_compra OWNER TO postgres;

--
-- TOC entry 307 (class 1259 OID 738197)
-- Name: presupuesto_compra_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.presupuesto_compra_detalle (
    id integer NOT NULL,
    estado character varying(255),
    monto bigint,
    id_pedido_compra_detalle integer,
    id_presuesto_compra integer
);


ALTER TABLE public.presupuesto_compra_detalle OWNER TO postgres;

--
-- TOC entry 308 (class 1259 OID 738200)
-- Name: presupuesto_compra_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.presupuesto_compra_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.presupuesto_compra_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4144 (class 0 OID 0)
-- Dependencies: 308
-- Name: presupuesto_compra_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.presupuesto_compra_detalle_id_seq OWNED BY public.presupuesto_compra_detalle.id;


--
-- TOC entry 309 (class 1259 OID 738202)
-- Name: presupuesto_compra_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.presupuesto_compra_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.presupuesto_compra_id_seq OWNER TO postgres;

--
-- TOC entry 4145 (class 0 OID 0)
-- Dependencies: 309
-- Name: presupuesto_compra_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.presupuesto_compra_id_seq OWNED BY public.presupuesto_compra.id;


--
-- TOC entry 310 (class 1259 OID 738204)
-- Name: presupuesto_servicio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.presupuesto_servicio (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    observacion character varying(255),
    total bigint,
    id_diagnostico integer,
    id_estado integer,
    id_promo_descuento integer,
    id_usuario integer
);


ALTER TABLE public.presupuesto_servicio OWNER TO postgres;

--
-- TOC entry 311 (class 1259 OID 738210)
-- Name: presupuesto_servicio_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.presupuesto_servicio_detalle (
    id integer NOT NULL,
    estado character varying(255),
    monto bigint,
    id_diagnostico_detalle integer,
    id_presuesto_servicio integer
);


ALTER TABLE public.presupuesto_servicio_detalle OWNER TO postgres;

--
-- TOC entry 312 (class 1259 OID 738213)
-- Name: presupuesto_servicio_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.presupuesto_servicio_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.presupuesto_servicio_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4146 (class 0 OID 0)
-- Dependencies: 312
-- Name: presupuesto_servicio_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.presupuesto_servicio_detalle_id_seq OWNED BY public.presupuesto_servicio_detalle.id;


--
-- TOC entry 313 (class 1259 OID 738215)
-- Name: presupuesto_servicio_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.presupuesto_servicio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.presupuesto_servicio_id_seq OWNER TO postgres;

--
-- TOC entry 4147 (class 0 OID 0)
-- Dependencies: 313
-- Name: presupuesto_servicio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.presupuesto_servicio_id_seq OWNED BY public.presupuesto_servicio.id;


--
-- TOC entry 314 (class 1259 OID 738217)
-- Name: promo_descuento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.promo_descuento (
    id integer NOT NULL,
    descripcion character varying(255),
    estado character varying(255),
    porcentaje bigint
);


ALTER TABLE public.promo_descuento OWNER TO postgres;

--
-- TOC entry 315 (class 1259 OID 738223)
-- Name: promo_descuento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.promo_descuento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.promo_descuento_id_seq OWNER TO postgres;

--
-- TOC entry 4148 (class 0 OID 0)
-- Dependencies: 315
-- Name: promo_descuento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.promo_descuento_id_seq OWNED BY public.promo_descuento.id;


--
-- TOC entry 316 (class 1259 OID 738225)
-- Name: proveedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.proveedor (
    id integer NOT NULL,
    razon_social character varying(50) NOT NULL,
    ruc character varying(60) NOT NULL,
    telefono character varying(60) NOT NULL,
    correo character varying(60) NOT NULL,
    direccion character varying(60) NOT NULL,
    id_ciudad integer NOT NULL,
    estado character varying
);


ALTER TABLE public.proveedor OWNER TO postgres;

--
-- TOC entry 317 (class 1259 OID 738231)
-- Name: proveedor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.proveedor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.proveedor_id_seq OWNER TO postgres;

--
-- TOC entry 4149 (class 0 OID 0)
-- Dependencies: 317
-- Name: proveedor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.proveedor_id_seq OWNED BY public.proveedor.id;


--
-- TOC entry 318 (class 1259 OID 738233)
-- Name: proveedores_prove_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.proveedores_prove_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.proveedores_prove_id_seq OWNER TO postgres;

--
-- TOC entry 4150 (class 0 OID 0)
-- Dependencies: 318
-- Name: proveedores_prove_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.proveedores_prove_id_seq OWNED BY public.proveedor.id;


--
-- TOC entry 319 (class 1259 OID 738235)
-- Name: recepcion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.recepcion (
    id integer NOT NULL,
    estado character varying(255),
    fecha timestamp without time zone,
    observacion character varying(255),
    id_estado integer,
    id_usuario integer,
    id_sucursal integer,
    id_cliente integer
);


ALTER TABLE public.recepcion OWNER TO postgres;

--
-- TOC entry 320 (class 1259 OID 738241)
-- Name: recepcion_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.recepcion_detalle (
    id integer NOT NULL,
    estado character varying(255),
    id_equipo integer,
    id_recepcion integer
);


ALTER TABLE public.recepcion_detalle OWNER TO postgres;

--
-- TOC entry 321 (class 1259 OID 738244)
-- Name: recepcion_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.recepcion_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.recepcion_detalle_id_seq OWNER TO postgres;

--
-- TOC entry 4151 (class 0 OID 0)
-- Dependencies: 321
-- Name: recepcion_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.recepcion_detalle_id_seq OWNED BY public.recepcion_detalle.id;


--
-- TOC entry 322 (class 1259 OID 738246)
-- Name: recepcion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.recepcion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.recepcion_id_seq OWNER TO postgres;

--
-- TOC entry 4152 (class 0 OID 0)
-- Dependencies: 322
-- Name: recepcion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.recepcion_id_seq OWNED BY public.recepcion.id;


--
-- TOC entry 323 (class 1259 OID 738248)
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rol (
    id integer NOT NULL,
    nombre character varying,
    id_usuario_auditoria integer,
    estado character varying
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- TOC entry 324 (class 1259 OID 738254)
-- Name: roles_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_rol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_rol_seq OWNER TO postgres;

--
-- TOC entry 4153 (class 0 OID 0)
-- Dependencies: 324
-- Name: roles_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_rol_seq OWNED BY public.rol.id;


--
-- TOC entry 325 (class 1259 OID 738256)
-- Name: servicio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.servicio (
    id integer NOT NULL,
    descripcion character varying(255),
    estado character varying(255),
    monto bigint,
    id_impuesto integer,
    id_articulo integer
);


ALTER TABLE public.servicio OWNER TO postgres;

--
-- TOC entry 326 (class 1259 OID 738262)
-- Name: servicio_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.servicio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.servicio_id_seq OWNER TO postgres;

--
-- TOC entry 4154 (class 0 OID 0)
-- Dependencies: 326
-- Name: servicio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.servicio_id_seq OWNED BY public.servicio.id;


--
-- TOC entry 327 (class 1259 OID 738264)
-- Name: servicios_por_diagnostico_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.servicios_por_diagnostico_detalle (
    id_diagnostico_detalle integer NOT NULL,
    id_servicio integer NOT NULL
);


ALTER TABLE public.servicios_por_diagnostico_detalle OWNER TO postgres;

--
-- TOC entry 328 (class 1259 OID 738267)
-- Name: sistema; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sistema (
    id integer NOT NULL,
    nombre character varying,
    id_usuario_auditoria integer,
    estado character varying
);


ALTER TABLE public.sistema OWNER TO postgres;

--
-- TOC entry 329 (class 1259 OID 738273)
-- Name: sistemas_id_sistema_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sistemas_id_sistema_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sistemas_id_sistema_seq OWNER TO postgres;

--
-- TOC entry 4155 (class 0 OID 0)
-- Dependencies: 329
-- Name: sistemas_id_sistema_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sistemas_id_sistema_seq OWNED BY public.sistema.id;


--
-- TOC entry 330 (class 1259 OID 738275)
-- Name: stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stock (
    id integer NOT NULL,
    estado character varying(255),
    existencia integer,
    id_articulo integer,
    id_deposito integer
);


ALTER TABLE public.stock OWNER TO postgres;

--
-- TOC entry 331 (class 1259 OID 738278)
-- Name: stock_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.stock_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.stock_id_seq OWNER TO postgres;

--
-- TOC entry 4156 (class 0 OID 0)
-- Dependencies: 331
-- Name: stock_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.stock_id_seq OWNED BY public.stock.id;


--
-- TOC entry 332 (class 1259 OID 738280)
-- Name: sub_menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sub_menu (
    id integer NOT NULL,
    nombre character varying,
    id_usuario_auditoria integer,
    estado character varying
);


ALTER TABLE public.sub_menu OWNER TO postgres;

--
-- TOC entry 333 (class 1259 OID 738286)
-- Name: submenus_id_submenu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.submenus_id_submenu_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.submenus_id_submenu_seq OWNER TO postgres;

--
-- TOC entry 4157 (class 0 OID 0)
-- Dependencies: 333
-- Name: submenus_id_submenu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.submenus_id_submenu_seq OWNED BY public.sub_menu.id;


--
-- TOC entry 334 (class 1259 OID 738288)
-- Name: sucursal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sucursal (
    id integer NOT NULL,
    descripcion character varying(250) NOT NULL,
    estado character varying,
    id_ciudad integer
);


ALTER TABLE public.sucursal OWNER TO postgres;

--
-- TOC entry 335 (class 1259 OID 738294)
-- Name: sucursales_suc_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sucursales_suc_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sucursales_suc_id_seq OWNER TO postgres;

--
-- TOC entry 4158 (class 0 OID 0)
-- Dependencies: 335
-- Name: sucursales_suc_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sucursales_suc_id_seq OWNED BY public.sucursal.id;


--
-- TOC entry 336 (class 1259 OID 738296)
-- Name: tarjeta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarjeta (
    id integer NOT NULL,
    descripcion character varying(50) NOT NULL,
    estado character varying
);


ALTER TABLE public.tarjeta OWNER TO postgres;

--
-- TOC entry 337 (class 1259 OID 738302)
-- Name: tarjeta_tarjeta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tarjeta_tarjeta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tarjeta_tarjeta_id_seq OWNER TO postgres;

--
-- TOC entry 4159 (class 0 OID 0)
-- Dependencies: 337
-- Name: tarjeta_tarjeta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tarjeta_tarjeta_id_seq OWNED BY public.tarjeta.id;


--
-- TOC entry 355 (class 1259 OID 739295)
-- Name: timbrado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.timbrado (
    id integer NOT NULL,
    estado character varying,
    inicio_vigencia date,
    fin_vigencia date,
    numero character varying
);


ALTER TABLE public.timbrado OWNER TO postgres;

--
-- TOC entry 354 (class 1259 OID 739293)
-- Name: timbrado_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.timbrado_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.timbrado_id_seq OWNER TO postgres;

--
-- TOC entry 4160 (class 0 OID 0)
-- Dependencies: 354
-- Name: timbrado_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.timbrado_id_seq OWNED BY public.timbrado.id;


--
-- TOC entry 338 (class 1259 OID 738310)
-- Name: tipo_articulo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_articulo (
    id integer NOT NULL,
    descripcion character varying NOT NULL,
    estado character varying
);


ALTER TABLE public.tipo_articulo OWNER TO postgres;

--
-- TOC entry 339 (class 1259 OID 738316)
-- Name: tipo_articulo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_articulo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_articulo_id_seq OWNER TO postgres;

--
-- TOC entry 4161 (class 0 OID 0)
-- Dependencies: 339
-- Name: tipo_articulo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_articulo_id_seq OWNED BY public.tipo_articulo.id;


--
-- TOC entry 340 (class 1259 OID 738318)
-- Name: tipo_cheque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_cheque (
    id integer NOT NULL,
    descripcion character varying,
    estado character varying
);


ALTER TABLE public.tipo_cheque OWNER TO postgres;

--
-- TOC entry 341 (class 1259 OID 738324)
-- Name: tipo_cheque_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_cheque_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_cheque_id_seq OWNER TO postgres;

--
-- TOC entry 4162 (class 0 OID 0)
-- Dependencies: 341
-- Name: tipo_cheque_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_cheque_id_seq OWNED BY public.tipo_cheque.id;


--
-- TOC entry 342 (class 1259 OID 738326)
-- Name: tipo_documento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_documento (
    id integer NOT NULL,
    descripcion character varying,
    estado character varying
);


ALTER TABLE public.tipo_documento OWNER TO postgres;

--
-- TOC entry 343 (class 1259 OID 738332)
-- Name: tipo_documento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_documento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_documento_id_seq OWNER TO postgres;

--
-- TOC entry 4163 (class 0 OID 0)
-- Dependencies: 343
-- Name: tipo_documento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_documento_id_seq OWNED BY public.tipo_documento.id;


--
-- TOC entry 344 (class 1259 OID 738334)
-- Name: tipo_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_item (
    id integer NOT NULL,
    descripcion character varying NOT NULL,
    estado character varying
);


ALTER TABLE public.tipo_item OWNER TO postgres;

--
-- TOC entry 345 (class 1259 OID 738340)
-- Name: tipo_item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_item_id_seq OWNER TO postgres;

--
-- TOC entry 4164 (class 0 OID 0)
-- Dependencies: 345
-- Name: tipo_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_item_id_seq OWNED BY public.tipo_item.id;


--
-- TOC entry 346 (class 1259 OID 738342)
-- Name: tipo_problema; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_problema (
    id integer NOT NULL,
    descripcion character varying(80) NOT NULL,
    estado character varying
);


ALTER TABLE public.tipo_problema OWNER TO postgres;

--
-- TOC entry 347 (class 1259 OID 738348)
-- Name: tipo_problemas_tip_proble_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_problemas_tip_proble_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_problemas_tip_proble_id_seq OWNER TO postgres;

--
-- TOC entry 4165 (class 0 OID 0)
-- Dependencies: 347
-- Name: tipo_problemas_tip_proble_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_problemas_tip_proble_id_seq OWNED BY public.tipo_problema.id;


--
-- TOC entry 348 (class 1259 OID 738350)
-- Name: tipo_tarjeta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_tarjeta (
    id integer NOT NULL,
    descripcion character varying,
    estado character varying
);


ALTER TABLE public.tipo_tarjeta OWNER TO postgres;

--
-- TOC entry 349 (class 1259 OID 738356)
-- Name: tipo_tarjeta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_tarjeta_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_tarjeta_id_seq OWNER TO postgres;

--
-- TOC entry 4166 (class 0 OID 0)
-- Dependencies: 349
-- Name: tipo_tarjeta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_tarjeta_id_seq OWNED BY public.tipo_tarjeta.id;


--
-- TOC entry 350 (class 1259 OID 738358)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id integer NOT NULL,
    nombre character varying,
    usuario character varying,
    clave character varying,
    imagen character varying,
    id_usuario_auditoria integer,
    estado character varying,
    id_sucursal integer,
    intentos_fallidos integer
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 351 (class 1259 OID 738364)
-- Name: usuario_rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario_rol (
    id integer NOT NULL,
    id_usuario integer,
    id_rol integer,
    id_usuario_auditoria integer,
    estado character varying
);


ALTER TABLE public.usuario_rol OWNER TO postgres;

--
-- TOC entry 352 (class 1259 OID 738370)
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuarios_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 4167 (class 0 OID 0)
-- Dependencies: 352
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuarios_id_usuario_seq OWNED BY public.usuario.id;


--
-- TOC entry 353 (class 1259 OID 738372)
-- Name: usuariosroles_id_usuariorol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuariosroles_id_usuariorol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuariosroles_id_usuariorol_seq OWNER TO postgres;

--
-- TOC entry 4168 (class 0 OID 0)
-- Dependencies: 353
-- Name: usuariosroles_id_usuariorol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuariosroles_id_usuariorol_seq OWNED BY public.usuario_rol.id;


--
-- TOC entry 3385 (class 2604 OID 738374)
-- Name: ajuste id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ajuste ALTER COLUMN id SET DEFAULT nextval('public.ajuste_id_seq'::regclass);


--
-- TOC entry 3386 (class 2604 OID 738375)
-- Name: apertura_cierre_caja id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apertura_cierre_caja ALTER COLUMN id SET DEFAULT nextval('public.apertura_cierre_caja_id_seq'::regclass);


--
-- TOC entry 3387 (class 2604 OID 738376)
-- Name: articulo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articulo ALTER COLUMN id SET DEFAULT nextval('public.articulo_id_seq'::regclass);


--
-- TOC entry 3388 (class 2604 OID 738377)
-- Name: banco id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.banco ALTER COLUMN id SET DEFAULT nextval('public.banco_banco_id_seq'::regclass);


--
-- TOC entry 3389 (class 2604 OID 738378)
-- Name: banco_cheque id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.banco_cheque ALTER COLUMN id SET DEFAULT nextval('public.banco_cheque_id_seq'::regclass);


--
-- TOC entry 3390 (class 2604 OID 738379)
-- Name: caja id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caja ALTER COLUMN id SET DEFAULT nextval('public.caja_caja_id_seq'::regclass);


--
-- TOC entry 3391 (class 2604 OID 738380)
-- Name: cargo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo ALTER COLUMN id SET DEFAULT nextval('public.cargo_id_seq'::regclass);


--
-- TOC entry 3392 (class 2604 OID 738381)
-- Name: ciudad id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad ALTER COLUMN id SET DEFAULT nextval('public.ciudad_id_seq'::regclass);


--
-- TOC entry 3393 (class 2604 OID 738382)
-- Name: cliente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);


--
-- TOC entry 3394 (class 2604 OID 738383)
-- Name: cobro id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cobro ALTER COLUMN id SET DEFAULT nextval('public.cobro_id_seq'::regclass);


--
-- TOC entry 3395 (class 2604 OID 738384)
-- Name: condicion_pago id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.condicion_pago ALTER COLUMN id SET DEFAULT nextval('public.condicion_pago_id_seq'::regclass);


--
-- TOC entry 3396 (class 2604 OID 738385)
-- Name: cuenta_a_cobrar id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta_a_cobrar ALTER COLUMN id SET DEFAULT nextval('public.cuenta_a_cobrar_id_seq'::regclass);


--
-- TOC entry 3397 (class 2604 OID 738386)
-- Name: cuenta_a_pagar id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta_a_pagar ALTER COLUMN id SET DEFAULT nextval('public.cuenta_a_pagar_id_seq'::regclass);


--
-- TOC entry 3400 (class 2604 OID 738387)
-- Name: diagnostico id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnostico ALTER COLUMN id SET DEFAULT nextval('public.diagnostico_id_seq'::regclass);


--
-- TOC entry 3401 (class 2604 OID 738388)
-- Name: diagnostico_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnostico_detalle ALTER COLUMN id SET DEFAULT nextval('public.diagnostico_detalle_id_seq'::regclass);


--
-- TOC entry 3403 (class 2604 OID 738389)
-- Name: empresa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empresa ALTER COLUMN id SET DEFAULT nextval('public.empresa_empre_id_seq'::regclass);


--
-- TOC entry 3404 (class 2604 OID 738390)
-- Name: encargado id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encargado ALTER COLUMN id SET DEFAULT nextval('public.encargado_enca_id_seq'::regclass);


--
-- TOC entry 3405 (class 2604 OID 738391)
-- Name: entidad_emisora id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entidad_emisora ALTER COLUMN id SET DEFAULT nextval('public.entidad_emisora_id_seq'::regclass);


--
-- TOC entry 3406 (class 2604 OID 738392)
-- Name: equipo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo ALTER COLUMN id SET DEFAULT nextval('public.equipos_equi_id_seq'::regclass);


--
-- TOC entry 3407 (class 2604 OID 738393)
-- Name: estado id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado ALTER COLUMN id SET DEFAULT nextval('public.estado_id_seq'::regclass);


--
-- TOC entry 3408 (class 2604 OID 738394)
-- Name: factura id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura ALTER COLUMN id SET DEFAULT nextval('public.factura_id_seq'::regclass);


--
-- TOC entry 3409 (class 2604 OID 738395)
-- Name: factura_compra id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_compra ALTER COLUMN id SET DEFAULT nextval('public.factura_compra_id_seq'::regclass);


--
-- TOC entry 3410 (class 2604 OID 738396)
-- Name: factura_compra_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_compra_detalle ALTER COLUMN id SET DEFAULT nextval('public.factura_compra_detalle_id_seq'::regclass);


--
-- TOC entry 3411 (class 2604 OID 738397)
-- Name: factura_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_detalle ALTER COLUMN id SET DEFAULT nextval('public.factura_detalle_id_seq'::regclass);


--
-- TOC entry 3412 (class 2604 OID 738398)
-- Name: forma_cobro id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.forma_cobro ALTER COLUMN id SET DEFAULT nextval('public.forma_cobro_form_id_seq'::regclass);


--
-- TOC entry 3413 (class 2604 OID 738399)
-- Name: formulario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formulario ALTER COLUMN id SET DEFAULT nextval('public.formularios_id_formulario_seq'::regclass);


--
-- TOC entry 3414 (class 2604 OID 738400)
-- Name: impuesto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.impuesto ALTER COLUMN id SET DEFAULT nextval('public.impuesto_id_seq'::regclass);


--
-- TOC entry 3415 (class 2604 OID 738401)
-- Name: item id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item ALTER COLUMN id SET DEFAULT nextval('public.items_item_id_seq'::regclass);


--
-- TOC entry 3416 (class 2604 OID 738402)
-- Name: libro_compra id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_compra ALTER COLUMN id SET DEFAULT nextval('public.libro_compra_id_seq'::regclass);


--
-- TOC entry 3417 (class 2604 OID 738403)
-- Name: libro_compra_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_compra_detalle ALTER COLUMN id SET DEFAULT nextval('public.libro_compra_detalle_id_seq'::regclass);


--
-- TOC entry 3418 (class 2604 OID 738404)
-- Name: libro_venta id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_venta ALTER COLUMN id SET DEFAULT nextval('public.libro_venta_id_seq'::regclass);


--
-- TOC entry 3419 (class 2604 OID 738405)
-- Name: libro_venta_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_venta_detalle ALTER COLUMN id SET DEFAULT nextval('public.libro_venta_detalle_id_seq'::regclass);


--
-- TOC entry 3420 (class 2604 OID 738406)
-- Name: marca id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marca ALTER COLUMN id SET DEFAULT nextval('public.marcas_mar_id_seq'::regclass);


--
-- TOC entry 3421 (class 2604 OID 738407)
-- Name: motivo_ajuste id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motivo_ajuste ALTER COLUMN id SET DEFAULT nextval('public.motivo_ajuste_maju_id_seq'::regclass);


--
-- TOC entry 3422 (class 2604 OID 738408)
-- Name: nota_credito_compra id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra ALTER COLUMN id SET DEFAULT nextval('public.nota_credito_compra_id_seq'::regclass);


--
-- TOC entry 3423 (class 2604 OID 738409)
-- Name: nota_credito_compra_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra_detalle ALTER COLUMN id SET DEFAULT nextval('public.nota_credito_compra_detalle_id_seq'::regclass);


--
-- TOC entry 3424 (class 2604 OID 738410)
-- Name: nota_debito_compra id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_debito_compra ALTER COLUMN id SET DEFAULT nextval('public.nota_debito_compra_id_seq'::regclass);


--
-- TOC entry 3425 (class 2604 OID 738411)
-- Name: nota_debito_compra_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_debito_compra_detalle ALTER COLUMN id SET DEFAULT nextval('public.nota_debito_compra_detalle_id_seq'::regclass);


--
-- TOC entry 3426 (class 2604 OID 738412)
-- Name: nota_remision id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision ALTER COLUMN id SET DEFAULT nextval('public.nota_remision_id_seq'::regclass);


--
-- TOC entry 3427 (class 2604 OID 738413)
-- Name: nota_remision_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision_detalle ALTER COLUMN id SET DEFAULT nextval('public.nota_remision_detalle_id_seq'::regclass);


--
-- TOC entry 3428 (class 2604 OID 738414)
-- Name: orden_compra id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra ALTER COLUMN id SET DEFAULT nextval('public.orden_compra_id_seq'::regclass);


--
-- TOC entry 3429 (class 2604 OID 738415)
-- Name: orden_compra_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra_detalle ALTER COLUMN id SET DEFAULT nextval('public.orden_compra_detalle_id_seq'::regclass);


--
-- TOC entry 3430 (class 2604 OID 738416)
-- Name: orden_servicio id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_servicio ALTER COLUMN id SET DEFAULT nextval('public.orden_servicio_id_seq'::regclass);


--
-- TOC entry 3431 (class 2604 OID 738417)
-- Name: orden_servicio_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_servicio_detalle ALTER COLUMN id SET DEFAULT nextval('public.orden_servicio_detalle_id_seq'::regclass);


--
-- TOC entry 3432 (class 2604 OID 738418)
-- Name: pago id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pago ALTER COLUMN id SET DEFAULT nextval('public.pago_id_seq'::regclass);


--
-- TOC entry 3433 (class 2604 OID 738419)
-- Name: pedido_compra id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra ALTER COLUMN id SET DEFAULT nextval('public.pedido_compra_id_seq'::regclass);


--
-- TOC entry 3399 (class 2604 OID 738420)
-- Name: pedido_compra_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra_detalle ALTER COLUMN id SET DEFAULT nextval('public.detalle_pedido_compra_id_seq'::regclass);


--
-- TOC entry 3434 (class 2604 OID 738421)
-- Name: pedido_venta id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venta ALTER COLUMN id SET DEFAULT nextval('public.pedido_venta_id_seq'::regclass);


--
-- TOC entry 3435 (class 2604 OID 738422)
-- Name: pedido_venta_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venta_detalle ALTER COLUMN id SET DEFAULT nextval('public.pedido_venta_detalle_id_seq'::regclass);


--
-- TOC entry 3436 (class 2604 OID 738423)
-- Name: permiso id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permiso ALTER COLUMN id SET DEFAULT nextval('public.permisos_id_permiso_seq'::regclass);


--
-- TOC entry 3402 (class 2604 OID 738424)
-- Name: persona id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona ALTER COLUMN id SET DEFAULT nextval('public.empleado_id_seq'::regclass);


--
-- TOC entry 3437 (class 2604 OID 738425)
-- Name: presupuesto_compra id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra ALTER COLUMN id SET DEFAULT nextval('public.presupuesto_compra_id_seq'::regclass);


--
-- TOC entry 3438 (class 2604 OID 738426)
-- Name: presupuesto_compra_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra_detalle ALTER COLUMN id SET DEFAULT nextval('public.presupuesto_compra_detalle_id_seq'::regclass);


--
-- TOC entry 3439 (class 2604 OID 738427)
-- Name: presupuesto_servicio id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_servicio ALTER COLUMN id SET DEFAULT nextval('public.presupuesto_servicio_id_seq'::regclass);


--
-- TOC entry 3440 (class 2604 OID 738428)
-- Name: presupuesto_servicio_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_servicio_detalle ALTER COLUMN id SET DEFAULT nextval('public.presupuesto_servicio_detalle_id_seq'::regclass);


--
-- TOC entry 3441 (class 2604 OID 738429)
-- Name: promo_descuento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.promo_descuento ALTER COLUMN id SET DEFAULT nextval('public.promo_descuento_id_seq'::regclass);


--
-- TOC entry 3442 (class 2604 OID 738430)
-- Name: proveedor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedor ALTER COLUMN id SET DEFAULT nextval('public.proveedores_prove_id_seq'::regclass);


--
-- TOC entry 3443 (class 2604 OID 738431)
-- Name: recepcion id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recepcion ALTER COLUMN id SET DEFAULT nextval('public.recepcion_id_seq'::regclass);


--
-- TOC entry 3444 (class 2604 OID 738432)
-- Name: recepcion_detalle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recepcion_detalle ALTER COLUMN id SET DEFAULT nextval('public.recepcion_detalle_id_seq'::regclass);


--
-- TOC entry 3445 (class 2604 OID 738433)
-- Name: rol id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol ALTER COLUMN id SET DEFAULT nextval('public.roles_id_rol_seq'::regclass);


--
-- TOC entry 3446 (class 2604 OID 738434)
-- Name: servicio id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servicio ALTER COLUMN id SET DEFAULT nextval('public.servicio_id_seq'::regclass);


--
-- TOC entry 3447 (class 2604 OID 738435)
-- Name: sistema id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sistema ALTER COLUMN id SET DEFAULT nextval('public.sistemas_id_sistema_seq'::regclass);


--
-- TOC entry 3448 (class 2604 OID 738436)
-- Name: stock id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock ALTER COLUMN id SET DEFAULT nextval('public.stock_id_seq'::regclass);


--
-- TOC entry 3449 (class 2604 OID 738437)
-- Name: sub_menu id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sub_menu ALTER COLUMN id SET DEFAULT nextval('public.submenus_id_submenu_seq'::regclass);


--
-- TOC entry 3450 (class 2604 OID 738438)
-- Name: sucursal id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sucursal ALTER COLUMN id SET DEFAULT nextval('public.sucursales_suc_id_seq'::regclass);


--
-- TOC entry 3451 (class 2604 OID 738439)
-- Name: tarjeta id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjeta ALTER COLUMN id SET DEFAULT nextval('public.tarjeta_tarjeta_id_seq'::regclass);


--
-- TOC entry 3460 (class 2604 OID 739298)
-- Name: timbrado id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.timbrado ALTER COLUMN id SET DEFAULT nextval('public.timbrado_id_seq'::regclass);


--
-- TOC entry 3452 (class 2604 OID 738441)
-- Name: tipo_articulo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_articulo ALTER COLUMN id SET DEFAULT nextval('public.tipo_articulo_id_seq'::regclass);


--
-- TOC entry 3453 (class 2604 OID 738442)
-- Name: tipo_cheque id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cheque ALTER COLUMN id SET DEFAULT nextval('public.tipo_cheque_id_seq'::regclass);


--
-- TOC entry 3454 (class 2604 OID 738443)
-- Name: tipo_documento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_documento ALTER COLUMN id SET DEFAULT nextval('public.tipo_documento_id_seq'::regclass);


--
-- TOC entry 3455 (class 2604 OID 738444)
-- Name: tipo_item id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_item ALTER COLUMN id SET DEFAULT nextval('public.tipo_item_id_seq'::regclass);


--
-- TOC entry 3456 (class 2604 OID 738445)
-- Name: tipo_problema id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_problema ALTER COLUMN id SET DEFAULT nextval('public.tipo_problemas_tip_proble_id_seq'::regclass);


--
-- TOC entry 3457 (class 2604 OID 738446)
-- Name: tipo_tarjeta id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_tarjeta ALTER COLUMN id SET DEFAULT nextval('public.tipo_tarjeta_id_seq'::regclass);


--
-- TOC entry 3458 (class 2604 OID 738447)
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_usuario_seq'::regclass);


--
-- TOC entry 3459 (class 2604 OID 738448)
-- Name: usuario_rol id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol ALTER COLUMN id SET DEFAULT nextval('public.usuariosroles_id_usuariorol_seq'::regclass);


--
-- TOC entry 3933 (class 0 OID 737822)
-- Dependencies: 202
-- Data for Name: ajuste; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ajuste (id, cantidad, descripcion, estado, fecha, tipo, id_stock, id_estado) FROM stdin;
1	4	SE ROMPIO	ACTIVO	2022-10-12 15:42:19.186	DESCUENTO	5	2
2	1	SE ROMPIO	ACTIVO	2022-10-13 09:08:14.727	DESCUENTO	5	4
3	1	SE ROMPIO	ACTIVO	2022-10-20 11:41:21.374	DESCUENTO	15	1
\.


--
-- TOC entry 3935 (class 0 OID 737830)
-- Dependencies: 204
-- Data for Name: apertura_cierre_caja; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.apertura_cierre_caja (id, descripcion, estado, fecha_hora_apertura, fecha_hora_cierre, monto_apertura, monto_cierre, monto_cierre_cheque, monto_cierre_efectivo, monto_cierre_tarjeta, id_caja, id_usuario) FROM stdin;
1	\N	ACTIVO	2022-10-07 11:25:47.392	\N	100000	\N	\N	\N	\N	5	1
2	\N	ACTIVO	2022-10-22 18:52:05.818	\N	0	\N	\N	\N	\N	5	1
\.


--
-- TOC entry 3937 (class 0 OID 737838)
-- Dependencies: 206
-- Data for Name: articulo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.articulo (id, descripcion, precio_compra, precio_venta, codigo_generico, id_impuesto, id_marca, id_tipo_articulo, estado, precio_compra_anterior, precio_venta_anterior) FROM stdin;
2	Prueba	25000	30000	1111	2	2	2	INACTIVO	\N	\N
8	MOUSE LOGITECH	110000	150000	4545	2	37	3	ACTIVO	100000	\N
7	MOUSEPAD	50000	30000	1450	2	37	3	ACTIVO	20000	\N
4	MOUSE	50000	50000	1414	2	2	3	ACTIVO	50000	\N
5	TECLADO	40000	60000	1515	2	20	3	ACTIVO	50000	\N
6	MONITOR	160000	150000	1452	2	22	3	ACTIVO	150000	\N
3	ARTICULO	45000	75000	1243	2	20	1	INACTIVO	\N	\N
10	CABLE FUENTE	15000	25000	1241	2	23	2	ACTIVO	\N	\N
9	CABLE SATA	15000	19500	1471	2	23	2	ACTIVO	15000	25000
\.


--
-- TOC entry 3939 (class 0 OID 737846)
-- Dependencies: 208
-- Data for Name: banco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.banco (id, descripcion, estado) FROM stdin;
1	ITAU	ACTIVO
\.


--
-- TOC entry 3941 (class 0 OID 737854)
-- Dependencies: 210
-- Data for Name: banco_cheque; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.banco_cheque (id, descripcion, estado) FROM stdin;
\.


--
-- TOC entry 3943 (class 0 OID 737862)
-- Dependencies: 212
-- Data for Name: caja; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.caja (id, descripcion, numero, estado, id_sucursal) FROM stdin;
1	DADAS	1	INACTIVO	2
2	JHKHKH	2	INACTIVO	5
5	CAJA 1	3	ACTIVO	2
6	CAJA 2	4	ACTIVO	5
7	CAJA 3	5	ACTIVO	6
8	CAJA 4	6	ACTIVO	7
9	CAJA 5	7	ACTIVO	2
10	PRUEBA	10	INACTIVO	2
11	CAJA 6	8	ACTIVO	14
\.


--
-- TOC entry 3945 (class 0 OID 737870)
-- Dependencies: 214
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cargo (id, descripcion, estado) FROM stdin;
1	CAJERO	ACTIVO
2	CONTADOR	ACTIVO
3	PRUEBA	INACTIVO
\.


--
-- TOC entry 3947 (class 0 OID 737878)
-- Dependencies: 216
-- Data for Name: ciudad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ciudad (id, descripcion, estado) FROM stdin;
5	FERNANDO DE LA MORA	ACTIVO
1	ASUNCIÓN	ACTIVO
2	SAN LORENZO	ACTIVO
3	CAPIATÁ	ACTIVO
6	ÑEMBY	ACTIVO
\.


--
-- TOC entry 3949 (class 0 OID 737886)
-- Dependencies: 218
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (id, correo, direccion, estado, razon, ruc, telefono, id_ciudad) FROM stdin;
1	JCESARQALONSO@GMAIL.COM	BERNARDINO CABALLERO 965	ACTIVO	JULIO QUINTANA	3763530-1	0961834314	6
2	DSADA	SADASDAS	INACTIVO	DASDASD	1231312	DSADA	2
\.


--
-- TOC entry 3951 (class 0 OID 737894)
-- Dependencies: 220
-- Data for Name: cobro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cobro (id, descripcion, estado, fecha, monto) FROM stdin;
\.


--
-- TOC entry 3953 (class 0 OID 737902)
-- Dependencies: 222
-- Data for Name: condicion_pago; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.condicion_pago (id, descripcion, estado) FROM stdin;
1	CONTADO	ACTIVO
2	CREDITO	ACTIVO
3	PRUEBA	INACTIVO
\.


--
-- TOC entry 3955 (class 0 OID 737910)
-- Dependencies: 224
-- Data for Name: cuenta_a_cobrar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cuenta_a_cobrar (id, cantidad_cuotas, estado, fecha_vencimiento, monto, numero_cuota, id_cobro, id_estado, id_factura) FROM stdin;
\.


--
-- TOC entry 3957 (class 0 OID 737915)
-- Dependencies: 226
-- Data for Name: cuenta_a_pagar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cuenta_a_pagar (id, cantidad_cuotas, estado, fecha_vencimiento, monto, numero_cuota, id_estado, id_pago) FROM stdin;
5	12	ACTIVO	2022-10-29 15:24:38.026	62500	1	2	\N
9	12	ACTIVO	2022-11-28 15:24:38.026	62500	2	2	\N
2	12	ACTIVO	2022-12-28 15:24:38.026	62500	3	2	\N
10	12	ACTIVO	2023-01-27 15:24:38.026	62500	4	2	\N
3	12	ACTIVO	2023-02-26 15:24:38.026	62500	5	2	\N
11	12	ACTIVO	2023-03-28 15:24:38.026	62500	6	2	\N
1	12	ACTIVO	2023-04-27 15:24:38.026	62500	7	2	\N
4	12	ACTIVO	2023-05-27 15:24:38.026	62500	8	2	\N
7	12	ACTIVO	2023-06-26 15:24:38.026	62500	9	2	\N
8	12	ACTIVO	2023-07-26 15:24:38.026	62500	10	2	\N
12	12	ACTIVO	2023-08-25 15:24:38.026	62500	11	2	\N
6	12	ACTIVO	2023-09-24 15:24:38.026	62500	12	2	\N
13	12	ACTIVO	2022-10-29 19:01:30.736	62500	1	2	\N
23	12	ACTIVO	2022-11-28 19:01:30.738	62500	2	2	\N
24	12	ACTIVO	2022-12-28 19:01:30.741	62500	3	2	\N
18	12	ACTIVO	2023-01-27 19:01:30.743	62500	4	2	\N
21	12	ACTIVO	2023-02-26 19:01:30.745	62500	5	2	\N
19	12	ACTIVO	2023-03-28 19:01:30.748	62500	6	2	\N
14	12	ACTIVO	2023-04-27 19:01:30.75	62500	7	2	\N
17	12	ACTIVO	2023-05-27 19:01:30.761	62500	8	2	\N
16	12	ACTIVO	2023-06-26 19:01:30.764	62500	9	2	\N
15	12	ACTIVO	2023-07-26 19:01:30.781	62500	10	2	\N
22	12	ACTIVO	2023-08-25 19:01:30.786	62500	11	2	\N
20	12	ACTIVO	2023-09-24 19:01:30.788	62500	12	2	\N
27	12	ACTIVO	2022-10-29 23:57:06.3	62500	1	2	\N
34	12	ACTIVO	2022-11-28 23:57:06.301	62500	2	2	\N
26	12	ACTIVO	2022-12-28 23:57:06.302	62500	3	2	\N
30	12	ACTIVO	2023-01-27 23:57:06.305	62500	4	2	\N
28	12	ACTIVO	2023-02-26 23:57:06.306	62500	5	2	\N
36	12	ACTIVO	2023-03-28 23:57:06.308	62500	6	2	\N
35	12	ACTIVO	2023-04-27 23:57:06.309	62500	7	2	\N
25	12	ACTIVO	2023-05-27 23:57:06.31	62500	8	2	\N
29	12	ACTIVO	2023-06-26 23:57:06.311	62500	9	2	\N
33	12	ACTIVO	2023-07-26 23:57:06.312	62500	10	2	\N
31	12	ACTIVO	2023-08-25 23:57:06.313	62500	11	2	\N
32	12	ACTIVO	2023-09-24 23:57:06.314	62500	12	2	\N
38	12	ACTIVO	2023-09-06 16:07:57.458	62500	11	1	\N
39	12	ACTIVO	2023-10-06 16:07:57.459	62500	12	1	\N
40	12	ACTIVO	2023-04-09 16:07:57.457	62500	6	1	\N
43	12	ACTIVO	2023-03-10 16:07:57.457	62500	5	1	\N
44	12	ACTIVO	2023-08-07 16:07:57.458	62500	10	1	\N
45	12	ACTIVO	2023-06-08 16:07:57.458	62500	8	1	\N
46	12	ACTIVO	2023-02-08 16:07:57.457	62500	4	1	\N
47	12	ACTIVO	2023-01-09 16:07:57.456	62500	3	1	\N
48	12	ACTIVO	2023-07-08 16:07:57.458	62500	9	1	\N
49	12	ACTIVO	2023-05-09 16:07:57.457	62500	7	1	\N
41	12	ACTIVO	2022-11-10 16:07:57.456	62500	1	4	1
42	12	ACTIVO	2022-12-10 16:07:57.456	62500	2	4	2
50	3	ACTIVO	2022-12-16 13:24:28.638	250000	2	1	\N
51	3	ACTIVO	2022-11-16 13:24:28.638	250000	1	1	\N
52	3	ACTIVO	2023-01-15 13:24:28.638	250000	3	1	\N
53	6	ACTIVO	2023-03-16 15:26:29.137	183333	5	1	\N
54	6	ACTIVO	2023-01-15 15:26:29.137	183333	3	1	\N
55	6	ACTIVO	2023-04-15 15:26:29.137	183333	6	1	\N
56	6	ACTIVO	2022-12-16 15:26:29.136	183333	2	1	\N
57	6	ACTIVO	2023-02-14 15:26:29.137	183333	4	1	\N
58	6	ACTIVO	2022-11-16 15:26:29.136	183333	1	1	\N
59	1	ACTIVO	2022-10-17 15:51:30.976	1000000	1	1	\N
60	1	ACTIVO	2022-10-17 16:20:52.981	750000	1	2	\N
61	12	ACTIVO	2023-01-16 08:51:29.755	73333	3	1	\N
62	12	ACTIVO	2023-10-13 08:51:29.757	73333	12	1	\N
63	12	ACTIVO	2023-09-13 08:51:29.757	73333	11	1	\N
64	12	ACTIVO	2022-12-17 08:51:29.755	73333	2	1	\N
65	12	ACTIVO	2023-03-17 08:51:29.756	73333	5	1	\N
66	12	ACTIVO	2023-08-14 08:51:29.757	73333	10	1	\N
67	12	ACTIVO	2023-02-15 08:51:29.756	73333	4	1	\N
68	12	ACTIVO	2023-07-15 08:51:29.757	73333	9	1	\N
69	12	ACTIVO	2022-11-17 08:51:29.755	73333	1	1	\N
70	12	ACTIVO	2023-04-16 08:51:29.756	73333	6	1	\N
71	12	ACTIVO	2023-06-15 08:51:29.756	73333	8	1	\N
72	12	ACTIVO	2023-05-16 08:51:29.756	73333	7	1	\N
73	12	ACTIVO	2023-01-18 11:17:19.443	95833	3	1	\N
74	12	ACTIVO	2023-05-18 11:17:19.443	95833	7	1	\N
75	12	ACTIVO	2023-04-18 11:17:19.443	95833	6	1	\N
76	12	ACTIVO	2023-06-17 11:17:19.443	95833	8	1	\N
77	12	ACTIVO	2023-02-17 11:17:19.443	95833	4	1	\N
78	12	ACTIVO	2023-10-15 11:17:19.444	95833	12	1	\N
79	12	ACTIVO	2022-12-19 11:17:19.442	95833	2	1	\N
80	12	ACTIVO	2023-03-19 11:17:19.443	95833	5	1	\N
82	12	ACTIVO	2023-08-16 11:17:19.444	95833	10	1	\N
83	12	ACTIVO	2023-09-15 11:17:19.444	95833	11	1	\N
84	12	ACTIVO	2023-07-17 11:17:19.443	95833	9	1	\N
81	12	ACTIVO	2022-11-19 11:17:19.442	95833	1	4	3
85	1	ACTIVO	2022-10-20 11:27:54.772	530000	1	1	\N
37	1	ACTIVO	2022-09-30 00:14:03.217	350000	1	4	4
86	1	ACTIVO	2022-10-23 21:59:52.311	150000	1	1	\N
\.


--
-- TOC entry 3960 (class 0 OID 737922)
-- Dependencies: 229
-- Data for Name: deposito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.deposito (id, descripcion, id_sucursal, estado) FROM stdin;
2	MATRIZ 1	7	ACTIVO
5	MATRIZ 2	7	ACTIVO
6	CENTRO	6	ACTIVO
7	SAN LORENZO	2	ACTIVO
8	SAN LORENZO 2	2	ACTIVO
1	DEPOSITO CENTRAL	\N	ACTIVO
10	FERNANDO DE LA MORA	5	ACTIVO
11	NUEVO	14	INACTIVO
12	ÑEMBY	14	ACTIVO
\.


--
-- TOC entry 3963 (class 0 OID 737934)
-- Dependencies: 232
-- Data for Name: diagnostico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.diagnostico (id, estado, fecha, observacion, id_estado, id_recepcion, id_usuario) FROM stdin;
1	ACTIVO	2022-10-21 11:19:56.232	MANTENIMIETNO COMPLETO	2	3	1
2	ACTIVO	2022-10-21 11:24:16.83	MANTENIMIENTO	2	3	1
3	ACTIVO	2022-10-21 14:51:45.627	MANTENIMIENTO DE DOS PC	2	5	1
5	ACTIVO	2022-10-22 10:36:29.455	MANTENIMIENTO	2	6	1
7	ACTIVO	2022-10-22 11:01:39.48	REPARACION	2	7	1
6	ACTIVO	2022-10-22 10:51:34.614	MANTENIMIENTO	2	6	1
8	ACTIVO	2022-10-22 15:44:24.044	MANTENIMIENTO	2	6	1
10	ACTIVO	2022-10-22 17:46:54.096	CAMBIO DE CABLE	4	8	1
9	ACTIVO	2022-10-22 16:01:34.331	MANTENIMIENTO	4	6	1
\.


--
-- TOC entry 3964 (class 0 OID 737940)
-- Dependencies: 233
-- Data for Name: diagnostico_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.diagnostico_detalle (id, diagnostico, estado, id_recepcion_detalle, id_diagnostico, id_servicio) FROM stdin;
1	LIMPIAR PC	ACTIVO	3	1	\N
2	LIMPIAR PC	ACTIVO	3	2	\N
3	MANTENIMIENTO HARDWARE	ACTIVO	5	3	\N
4	MANTENIMIENTO SOFTWARE	ACTIVO	6	3	\N
8	MANTENIMIENTO HARDWARE	ACTIVO	7	5	\N
7	MANTENIMIENTO SOFTWARE	ACTIVO	8	5	\N
10	HARDWARE	ACTIVO	7	6	\N
9	SOFTWARE	ACTIVO	8	6	\N
11	CABLE DAÑADO	ACTIVO	9	7	\N
12	HARDWARE	ACTIVO	7	8	\N
13	SOFTWARE	ACTIVO	8	8	\N
14	H Y S	ACTIVO	7	9	\N
15	H	ACTIVO	8	9	\N
16	CABLE QUEMADO	ACTIVO	10	10	\N
\.


--
-- TOC entry 3969 (class 0 OID 737958)
-- Dependencies: 238
-- Data for Name: empresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.empresa (id, telefono, direccion, nombre, ruc, estado) FROM stdin;
6	(0961)43242	wewqe	EMPRESA	121515-4	ACTIVO
\.


--
-- TOC entry 3971 (class 0 OID 737966)
-- Dependencies: 240
-- Data for Name: encargado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.encargado (id, id_sucursal, nombre, apellido, direccion, telefono, email) FROM stdin;
2	2	Pedro1	Gonzales	Rio yhaguy	123123123	Pedro@
\.


--
-- TOC entry 3973 (class 0 OID 737971)
-- Dependencies: 242
-- Data for Name: entidad_emisora; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.entidad_emisora (id, descripcion, estado) FROM stdin;
1	BANCO FAMILIAR	ACTIVO
2	PRUEBA	INACTIVO
\.


--
-- TOC entry 3975 (class 0 OID 737979)
-- Dependencies: 244
-- Data for Name: equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipo (id, serie, descripcion, modelo, id_marca, estado, id_cliente) FROM stdin;
10	3435345	PC	LG-1SD	2	ACTIVO	1
4	R-3RFFDKD	PC	DELL_404	18	ACTIVO	1
11	PRUEBA_LS33	NOTEBOOK	HP-PAVILLION	18	ACTIVO	1
13	LS-12	COMPUTADORA	LG_404	1	ACTIVO	1
16	12020-021	NOTEBOOK	SONY VAIO	38	ACTIVO	1
17	PRUEBA	PRUEBA	PRUEBA	1	INACTIVO	1
18	XLS-12	MOUSE	ALPHA 1	37	ACTIVO	1
\.


--
-- TOC entry 3977 (class 0 OID 737987)
-- Dependencies: 246
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estado (id, descripcion, estado) FROM stdin;
1	PENDIENTE	ACTIVO
2	ANULADO	ACTIVO
3	FINALIZADO	ACTIVO
4	PROCESADO	ACTIVO
5	PENDIENTE_PAGO	ACTIVO
6	PAGADO	ACTIVO
7	PROCESADO_NOTA_CREDITO	ACTIVO
8	PRUEBA 2	INACTIVO
9	PRUEBA	INACTIVO
\.


--
-- TOC entry 3979 (class 0 OID 737995)
-- Dependencies: 248
-- Data for Name: factura; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.factura (id, estado, fecha, monto, numerofactura, observacion, id_caja, id_condicion_pago, id_estado, id_libro_venta, id_pedido_venta, id_timbrado, id_usuario) FROM stdin;
3	ACTIVO	2022-10-28 16:30:41.101	200000	012-008-0000001	SERVICIO Y VENTA	11	1	2	3	2	2	1
\.


--
-- TOC entry 3980 (class 0 OID 738001)
-- Dependencies: 249
-- Data for Name: factura_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.factura_compra (id, estado, fecha, monto, numero_factura, observacion, id_estado, id_libro_compra, id_orden_compra, id_usuario) FROM stdin;
1	ACTIVO	2022-09-29 15:08:32.116	750000	1000-22-002	COMPRA MOUSE	2	1	2	1
2	ACTIVO	2022-09-29 19:00:58.693	750000	12000-20202-20	COMPRA MOUSE	2	2	2	1
3	ACTIVO	2022-09-29 23:56:24.077	750000	12020-022-022	COMPRA MOUSE	2	3	2	1
4	ACTIVO	2022-09-30 00:13:15.643	350000	120000-002-022	COMPRA TECLADO	4	4	3	1
5	ACTIVO	2022-10-11 16:07:31.161	750000	123112-002-22	COMPRA MOUSE	4	5	2	1
6	ACTIVO	2022-10-17 13:23:59.383	750000	10000-22023-30	COMPRA MONITOR	4	6	4	1
7	ACTIVO	2022-10-17 15:26:09.673	1100000	111120000.-323-21	COMPRA MOUSE LOGITECH	7	7	6	1
8	ACTIVO	2022-10-17 15:50:51.891	1000000	110000-200-22	MOUSE Y MOUSEPAD	7	8	7	1
9	ACTIVO	2022-10-17 16:20:33.645	530000	12000-220-20	COMPRA TECLADO	2	9	8	1
10	ACTIVO	2022-10-18 08:50:39.697	880000	120000-022-200	COMPRA DE MOUSE Y TECLADO	4	10	14	1
11	ACTIVO	2022-10-20 11:16:09.972	1150000	10000-201-02	COMPRA DE TECLADO Y MONITOR	7	11	15	1
12	ACTIVO	2022-10-20 11:26:49.541	530000	12302-0212-000	MONITOR	7	12	16	1
13	ACTIVO	2022-10-23 21:59:34.207	150000	1202050-029-02	CABLE SATA	4	13	18	1
\.


--
-- TOC entry 3981 (class 0 OID 738007)
-- Dependencies: 250
-- Data for Name: factura_compra_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.factura_compra_detalle (id, estado, id_orden_compra_detalle, id_factura_compra) FROM stdin;
4	ACTIVO	7	1
1	ACTIVO	6	1
3	ACTIVO	4	1
2	ACTIVO	5	1
5	ACTIVO	7	2
6	ACTIVO	6	2
7	ACTIVO	4	2
8	ACTIVO	5	2
11	ACTIVO	7	3
9	ACTIVO	6	3
12	ACTIVO	4	3
10	ACTIVO	5	3
13	ACTIVO	8	4
17	ACTIVO	7	5
14	ACTIVO	6	5
15	ACTIVO	4	5
16	ACTIVO	5	5
18	ACTIVO	9	6
19	ACTIVO	11	7
21	ACTIVO	12	8
20	ACTIVO	13	8
22	ACTIVO	14	9
25	ACTIVO	24	10
23	ACTIVO	25	10
24	ACTIVO	26	10
27	ACTIVO	28	11
26	ACTIVO	27	11
28	ACTIVO	29	12
29	ACTIVO	31	13
\.


--
-- TOC entry 3984 (class 0 OID 738014)
-- Dependencies: 253
-- Data for Name: factura_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.factura_detalle (id, estado, monto, id_oreden_servicio_detalle, id_pedido_venta_detalle, id_factura) FROM stdin;
6	ACTIVO	150000	\N	3	3
5	ACTIVO	50000	5	\N	3
\.


--
-- TOC entry 3987 (class 0 OID 738021)
-- Dependencies: 256
-- Data for Name: forma_cobro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.forma_cobro (id, descripcion, estado) FROM stdin;
3	prueba1	ACTIVO
1	prueba2	ACTIVO
\.


--
-- TOC entry 3989 (class 0 OID 738029)
-- Dependencies: 258
-- Data for Name: formulario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.formulario (id, nombre, url, id_sistema, id_sub_menu, id_usuario_auditoria, estado) FROM stdin;
26	Promocion - Descuento	/promodescuento	2	1	\N	ACTIVO
27	Servicio	/servicio	2	1	\N	ACTIVO
28	Diagnostico	/diagnostico	2	2	\N	ACTIVO
29	Recepcion	/recepcion	2	2	\N	ACTIVO
30	Cliente	/cliente	1	1	\N	ACTIVO
31	Deposito	/deposito	1	1	\N	ACTIVO
32	Sucursal	/sucursal	1	1	\N	ACTIVO
33	Pedidos Venta	/pedidoventa	3	2	\N	ACTIVO
34	Stock	/stock	3	2	\N	ACTIVO
9	Entidad Emisora	/entidademisora	3	1	\N	ACTIVO
35	Presupuesto Servicio	/presupuestoservicio	2	2	\N	ACTIVO
36	Orden Servicio	/ordenservicio	2	2	\N	ACTIVO
1	Equipos	/equipo	2	1	\N	ACTIVO
2	Marcas	/marca	4	1	\N	ACTIVO
3	Proveedores	/proveedor	4	1	\N	ACTIVO
4	Ciudad	/ciudad	4	1	\N	ACTIVO
5	Impuesto	/impuesto	4	1	\N	ACTIVO
6	Tipo de Articulo	/tipoarticulo	4	1	\N	ACTIVO
7	Cargo	/cargo	1	1	\N	ACTIVO
8	Estado	/estado	1	1	\N	ACTIVO
10	Condicion de Pago	/condicionpago	3	1	\N	ACTIVO
11	Tipo de Tarjetas	/tipotarjeta	3	1	\N	ACTIVO
12	Articulo	/articulo	4	1	\N	ACTIVO
13	Pedidos Compra	/pedidocompra	4	2	\N	ACTIVO
14	Presupuesto Compra	/presupuestocompra	4	2	\N	ACTIVO
15	Orden Compra	/ordencompra	4	2	\N	ACTIVO
16	Factura Compra	/facturacompra	4	2	\N	ACTIVO
17	Nota Remision	/notaremision	4	2	\N	ACTIVO
18	Nota Debito Compra	/notadebitocompra	4	2	\N	ACTIVO
19	Libro Compra	/librocompra	4	2	\N	ACTIVO
20	Nota Credito Compra	/notacreditocompra	4	2	\N	ACTIVO
21	Cuentas a Pagar	/cuentaapagar	4	2	\N	ACTIVO
22	Apertura Cierre Caja	/aperturacierrecaja	3	2	\N	ACTIVO
23	Caja	/caja	3	1	\N	ACTIVO
24	Ajuste	/ajuste	4	2	\N	ACTIVO
25	Pago	/pago	4	2	\N	ACTIVO
37	Factura	/factura	3	2	\N	ACTIVO
38	Timbrado	/timbrado	3	1	\N	ACTIVO
39	Libro Venta	/libroventa	3	2	\N	ACTIVO
40	Cuentas a Cobrar	/cuentaacobrar	3	2	\N	ACTIVO
41	Usuario	/usuario	1	1	\N	ACTIVO
42	Rol	/rol	1	1	\N	ACTIVO
43	Formulario	/formulario	1	1	\N	ACTIVO
\.


--
-- TOC entry 3991 (class 0 OID 738037)
-- Dependencies: 260
-- Data for Name: impuesto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.impuesto (id, descripcion, estado, porcentaje_impuesto) FROM stdin;
1	GRAVADO 5%	ACTIVO	5
2	GRAVADO 10%	ACTIVO	10
3	EXENTO	ACTIVO	0
\.


--
-- TOC entry 3993 (class 0 OID 738045)
-- Dependencies: 262
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item (id, descripcion, precio, stock, id_marca, estado) FROM stdin;
3	prueba2	800000	45	2	ACTIVO
1	notebooktuni	60000	15	1	ACTIVO
\.


--
-- TOC entry 3995 (class 0 OID 738053)
-- Dependencies: 264
-- Data for Name: libro_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libro_compra (id, estado, fecha, monto_iva_10, monto_iva_5, montoneto) FROM stdin;
1	INACTIVO	2022-09-29 15:24:38.026	68182	0	681818
2	INACTIVO	2022-09-29 19:01:30.735	68182	0	681818
3	INACTIVO	2022-09-29 23:57:06.3	68182	0	681818
4	ACTIVO	2022-09-30 00:14:03.217	31818	0	318182
5	ACTIVO	2022-10-11 16:07:57.455	68182	0	681818
6	ACTIVO	2022-10-17 13:24:28.638	68182	0	681818
7	ACTIVO	2022-10-17 15:26:29.136	100000	0	1000000
8	ACTIVO	2022-10-17 15:51:30.976	90910	0	909090
9	INACTIVO	2022-10-17 16:20:52.98	68182	0	681818
10	ACTIVO	2022-10-18 08:51:29.755	113636	0	1136364
11	ACTIVO	2022-10-20 11:17:19.442	104546	0	1045454
12	ACTIVO	2022-10-20 11:27:54.772	72727	0	727273
13	ACTIVO	2022-10-23 21:59:52.311	13636	0	136364
\.


--
-- TOC entry 3996 (class 0 OID 738056)
-- Dependencies: 265
-- Data for Name: libro_compra_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libro_compra_detalle (id, estado, monto_impuesto, monto_neto, id_factura_compra_detalle, id_impuesto, id_libro_compra) FROM stdin;
6	INACTIVO	27273	272727	\N	2	2
8	INACTIVO	18182	181818	\N	2	2
7	INACTIVO	13636	136364	\N	2	2
5	INACTIVO	9091	90909	\N	2	2
11	INACTIVO	27273	272727	11	2	3
12	INACTIVO	18182	181818	9	2	3
9	INACTIVO	13636	136364	12	2	3
10	INACTIVO	9091	90909	10	2	3
13	ACTIVO	31818	318182	13	2	4
15	ACTIVO	27273	272727	17	2	5
14	ACTIVO	18182	181818	14	2	5
16	ACTIVO	13636	136364	15	2	5
17	ACTIVO	9091	90909	16	2	5
18	ACTIVO	68182	681818	18	2	6
19	ACTIVO	100000	1000000	19	2	7
21	ACTIVO	45455	454545	21	2	8
20	ACTIVO	45455	454545	20	2	8
22	INACTIVO	68182	681818	22	2	9
25	ACTIVO	68182	681818	25	2	10
23	ACTIVO	22727	227273	23	2	10
24	ACTIVO	22727	227273	24	2	10
26	ACTIVO	68182	681818	27	2	11
27	ACTIVO	36364	363636	26	2	11
28	ACTIVO	72727	727273	28	2	12
29	ACTIVO	13636	136364	29	2	13
\.


--
-- TOC entry 3999 (class 0 OID 738063)
-- Dependencies: 268
-- Data for Name: libro_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libro_venta (id, estado, fecha, monto_iva_10, monto_iva_5, montoneto) FROM stdin;
3	INACTIVO	2022-10-28 16:32:57.497	18181	0	181819
\.


--
-- TOC entry 4000 (class 0 OID 738066)
-- Dependencies: 269
-- Data for Name: libro_venta_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libro_venta_detalle (id, estado, monto_impuesto, monto_neto, id_factura_detalle, id_impuesto, id_libro_venta) FROM stdin;
5	INACTIVO	13636	136364	6	2	3
6	INACTIVO	4545	45455	5	2	3
\.


--
-- TOC entry 4003 (class 0 OID 738073)
-- Dependencies: 272
-- Data for Name: marca; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marca (id, descripcion, estado) FROM stdin;
2	HP	ACTIVO
1	ACER	ACTIVO
18	DELL	ACTIVO
20	LG	ACTIVO
36	APPLE	ACTIVO
22	TOKYO	ACTIVO
23	SAMSUNG	ACTIVO
37	LOGITECH	ACTIVO
38	SONY	ACTIVO
34	123A	INACTIVO
\.


--
-- TOC entry 4005 (class 0 OID 738081)
-- Dependencies: 274
-- Data for Name: motivo_ajuste; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.motivo_ajuste (id, descripcion, estado) FROM stdin;
2	tt	ACTIVO
\.


--
-- TOC entry 4007 (class 0 OID 738089)
-- Dependencies: 276
-- Data for Name: nota_credito_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nota_credito_compra (id, estado, fecha, monto, observacion, id_estado, id_factura_compra, id_proveedor, id_orden_compra_cancelacion, id_usuario) FROM stdin;
1	ACTIVO	2022-10-17 13:24:45.428	150000	MONITOR LLEGO ROTO	2	6	3	\N	1
2	ACTIVO	2022-10-17 14:24:20.101	300000	MONITOR ROTO	2	6	3	\N	1
3	ACTIVO	2022-10-17 15:26:42.303	220000	LLEGARON ROTOS	4	7	3	14	1
4	ACTIVO	2022-10-17 15:51:47.888	150000	FALTABAN	4	8	3	14	1
5	ACTIVO	2022-10-20 11:23:11.274	270000	LLEGARON ROTOS	4	11	3	16	1
6	ACTIVO	2022-10-22 16:18:58.291	160000	SE ROMPIO	4	12	3	17	1
\.


--
-- TOC entry 4008 (class 0 OID 738095)
-- Dependencies: 277
-- Data for Name: nota_credito_compra_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nota_credito_compra_detalle (id, cantidad, estado, monto, id_articulo, id_nota_credito_compra) FROM stdin;
1	1	ACTIVO	150000	6	1
2	2	ACTIVO	150000	6	2
3	2	ACTIVO	110000	8	3
4	1	ACTIVO	50000	4	4
5	2	ACTIVO	50000	7	4
6	1	ACTIVO	150000	6	5
7	3	ACTIVO	40000	5	5
8	1	ACTIVO	160000	6	6
\.


--
-- TOC entry 4011 (class 0 OID 738102)
-- Dependencies: 280
-- Data for Name: nota_debito_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nota_debito_compra (id, estado, monto, numero, observacion, id_cuenta_a_pagar, id_estado, id_factura_compra) FROM stdin;
29	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	31	2	3
23	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	13	2	2
17	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	23	2	2
19	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	24	2	2
16	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	18	2	2
22	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	21	2	2
15	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	19	2	2
14	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	14	2	2
20	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	17	2	2
24	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	16	2	2
18	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	15	2	2
21	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	22	2	2
5	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	5	2	1
8	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	9	2	1
4	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	2	2	1
3	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	10	2	1
6	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	3	2	1
9	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	11	2	1
10	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	1	2	1
1	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	4	2	1
12	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	7	2	1
7	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	8	2	1
11	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	12	2	1
2	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1000-22-002	6	2	1
25	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	32	2	3
13	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-20202-20	20	2	2
27	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	27	2	3
30	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	34	2	3
26	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	26	2	3
28	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	30	2	3
33	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	28	2	3
32	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	36	2	3
34	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	35	2	3
36	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	25	2	3
31	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	29	2	3
35	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12020-022-022	33	2	3
57	ACTIVO	183333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 111120000.-323-21	58	1	7
54	ACTIVO	183333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 111120000.-323-21	56	1	7
47	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	47	1	5
46	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	46	1	5
45	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	43	1	5
43	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	40	1	5
48	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	49	1	5
49	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	45	1	5
41	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	48	1	5
40	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	44	1	5
44	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	38	1	5
38	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	39	1	5
39	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	41	4	5
42	ACTIVO	62500	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 123112-002-22	42	4	5
51	ACTIVO	250000	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-22023-30	51	1	6
50	ACTIVO	250000	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-22023-30	50	1	6
52	ACTIVO	250000	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-22023-30	52	1	6
56	ACTIVO	183333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 111120000.-323-21	54	1	7
55	ACTIVO	183333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 111120000.-323-21	57	1	7
58	ACTIVO	183333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 111120000.-323-21	53	1	7
53	ACTIVO	183333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 111120000.-323-21	55	1	7
59	ACTIVO	1000000	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 110000-200-22	59	1	8
60	ACTIVO	750000	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12000-220-20	60	2	9
61	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	69	1	10
72	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	64	1	10
66	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	61	1	10
71	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	67	1	10
63	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	65	1	10
64	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	70	1	10
68	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	72	1	10
70	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	71	1	10
65	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	68	1	10
62	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	66	1	10
67	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	63	1	10
69	ACTIVO	73333	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-022-200	62	1	10
81	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	79	1	11
79	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	73	1	11
82	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	77	1	11
83	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	80	1	11
75	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	75	1	11
77	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	74	1	11
73	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	76	1	11
74	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	84	1	11
84	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	82	1	11
76	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	83	1	11
78	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	78	1	11
80	ACTIVO	95833	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 10000-201-02	81	4	11
85	ACTIVO	530000	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 12302-0212-000	85	1	12
37	ACTIVO	350000	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 120000-002-022	37	4	4
86	ACTIVO	150000	\N	GENERADO AUTOMATICAMENTE POR FACTURA NUMERO : 1202050-029-02	86	1	13
\.


--
-- TOC entry 4012 (class 0 OID 738108)
-- Dependencies: 281
-- Data for Name: nota_debito_compra_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nota_debito_compra_detalle (id, estado, id_factura_compra_detalle, id_nota_debito) FROM stdin;
37	ACTIVO	\N	13
28	ACTIVO	\N	13
45	ACTIVO	\N	13
15	ACTIVO	\N	13
40	ACTIVO	\N	14
47	ACTIVO	\N	14
6	ACTIVO	\N	14
42	ACTIVO	\N	14
1	ACTIVO	\N	15
38	ACTIVO	\N	15
19	ACTIVO	\N	15
11	ACTIVO	\N	15
31	ACTIVO	\N	16
48	ACTIVO	\N	16
35	ACTIVO	\N	16
33	ACTIVO	\N	16
39	ACTIVO	\N	17
14	ACTIVO	\N	17
30	ACTIVO	\N	17
41	ACTIVO	\N	17
20	ACTIVO	\N	18
36	ACTIVO	\N	18
27	ACTIVO	\N	18
13	ACTIVO	\N	18
44	ACTIVO	\N	19
43	ACTIVO	\N	19
8	ACTIVO	\N	19
34	ACTIVO	\N	19
21	ACTIVO	\N	20
9	ACTIVO	\N	20
18	ACTIVO	\N	20
25	ACTIVO	\N	20
29	ACTIVO	\N	21
26	ACTIVO	\N	21
2	ACTIVO	\N	21
23	ACTIVO	\N	21
5	ACTIVO	\N	22
3	ACTIVO	\N	22
17	ACTIVO	\N	22
10	ACTIVO	\N	22
24	ACTIVO	\N	23
32	ACTIVO	\N	23
16	ACTIVO	\N	23
4	ACTIVO	\N	23
46	ACTIVO	\N	24
7	ACTIVO	\N	24
12	ACTIVO	\N	24
22	ACTIVO	\N	24
62	ACTIVO	11	33
61	ACTIVO	9	33
67	ACTIVO	12	33
49	ACTIVO	10	33
80	ACTIVO	11	32
68	ACTIVO	9	32
65	ACTIVO	12	32
77	ACTIVO	10	32
72	ACTIVO	11	34
71	ACTIVO	9	34
84	ACTIVO	12	34
57	ACTIVO	10	34
93	ACTIVO	11	36
55	ACTIVO	9	36
85	ACTIVO	12	36
58	ACTIVO	10	36
53	ACTIVO	11	27
75	ACTIVO	9	27
79	ACTIVO	12	27
73	ACTIVO	10	27
86	ACTIVO	11	30
59	ACTIVO	9	30
83	ACTIVO	12	30
52	ACTIVO	10	30
92	ACTIVO	11	26
50	ACTIVO	9	26
90	ACTIVO	12	26
95	ACTIVO	10	26
88	ACTIVO	11	28
91	ACTIVO	9	28
96	ACTIVO	12	28
81	ACTIVO	10	28
69	ACTIVO	11	31
64	ACTIVO	9	31
94	ACTIVO	12	31
60	ACTIVO	10	31
70	ACTIVO	11	35
76	ACTIVO	9	35
87	ACTIVO	12	35
89	ACTIVO	10	35
51	ACTIVO	11	29
54	ACTIVO	9	29
74	ACTIVO	12	29
56	ACTIVO	10	29
82	ACTIVO	11	25
63	ACTIVO	9	25
66	ACTIVO	12	25
78	ACTIVO	10	25
97	ACTIVO	13	37
128	ACTIVO	16	40
107	ACTIVO	17	44
145	ACTIVO	14	44
114	ACTIVO	15	44
100	ACTIVO	16	44
124	ACTIVO	17	38
118	ACTIVO	14	38
131	ACTIVO	15	38
122	ACTIVO	16	38
144	ACTIVO	17	39
137	ACTIVO	14	39
112	ACTIVO	15	39
106	ACTIVO	16	39
101	ACTIVO	17	42
123	ACTIVO	14	42
135	ACTIVO	15	42
120	ACTIVO	16	42
126	ACTIVO	17	45
130	ACTIVO	14	45
129	ACTIVO	15	45
134	ACTIVO	17	43
111	ACTIVO	14	43
143	ACTIVO	15	43
121	ACTIVO	16	43
109	ACTIVO	17	41
132	ACTIVO	14	41
104	ACTIVO	15	41
119	ACTIVO	16	41
140	ACTIVO	17	40
139	ACTIVO	14	40
116	ACTIVO	15	40
103	ACTIVO	17	47
108	ACTIVO	14	47
136	ACTIVO	15	47
99	ACTIVO	16	47
142	ACTIVO	17	46
138	ACTIVO	14	46
113	ACTIVO	15	46
133	ACTIVO	16	46
117	ACTIVO	16	45
105	ACTIVO	17	48
115	ACTIVO	14	48
127	ACTIVO	15	48
141	ACTIVO	16	48
102	ACTIVO	17	49
110	ACTIVO	14	49
125	ACTIVO	15	49
98	ACTIVO	16	49
164	ACTIVO	24	64
187	ACTIVO	25	68
171	ACTIVO	23	68
147	ACTIVO	18	51
148	ACTIVO	18	50
146	ACTIVO	18	52
174	ACTIVO	24	68
168	ACTIVO	25	70
191	ACTIVO	23	70
190	ACTIVO	24	70
184	ACTIVO	25	65
166	ACTIVO	23	65
152	ACTIVO	19	57
153	ACTIVO	19	54
151	ACTIVO	19	56
149	ACTIVO	19	55
154	ACTIVO	19	58
150	ACTIVO	19	53
182	ACTIVO	24	65
188	ACTIVO	25	62
155	ACTIVO	21	59
156	ACTIVO	20	59
162	ACTIVO	23	62
157	ACTIVO	22	60
178	ACTIVO	24	62
172	ACTIVO	25	67
161	ACTIVO	23	67
195	ACTIVO	26	73
209	ACTIVO	27	74
207	ACTIVO	26	74
181	ACTIVO	24	67
180	ACTIVO	25	69
167	ACTIVO	23	69
170	ACTIVO	24	69
202	ACTIVO	27	84
214	ACTIVO	26	84
211	ACTIVO	27	76
197	ACTIVO	26	76
199	ACTIVO	27	78
212	ACTIVO	26	78
218	ACTIVO	28	85
192	ACTIVO	25	61
175	ACTIVO	23	61
189	ACTIVO	24	61
176	ACTIVO	25	72
159	ACTIVO	23	72
179	ACTIVO	24	72
169	ACTIVO	25	66
165	ACTIVO	23	66
183	ACTIVO	24	66
173	ACTIVO	25	71
186	ACTIVO	23	71
185	ACTIVO	24	71
163	ACTIVO	25	63
177	ACTIVO	23	63
193	ACTIVO	24	63
158	ACTIVO	25	64
160	ACTIVO	23	64
204	ACTIVO	27	80
194	ACTIVO	26	80
213	ACTIVO	27	81
196	ACTIVO	26	81
205	ACTIVO	27	79
203	ACTIVO	26	79
206	ACTIVO	27	82
201	ACTIVO	26	82
210	ACTIVO	27	83
216	ACTIVO	26	83
200	ACTIVO	27	75
208	ACTIVO	26	75
215	ACTIVO	27	77
198	ACTIVO	26	77
217	ACTIVO	27	73
219	ACTIVO	29	86
\.


--
-- TOC entry 4015 (class 0 OID 738115)
-- Dependencies: 284
-- Data for Name: nota_remision; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nota_remision (id, estado, fecha, observacion, tipo, id_destino, id_estado, id_origen, id_pedido_compra, id_factura_compra, id_usuario) FROM stdin;
1	ACTIVO	2022-09-29 15:24:38.026	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	5	2	1	6	1	\N
3	ACTIVO	2022-09-29 15:24:38.026	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	2	1	9	1	\N
2	ACTIVO	2022-09-29 15:24:38.026	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	2	1	10	1	\N
6	ACTIVO	2022-09-29 19:01:30.735	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	5	2	1	6	2	\N
4	ACTIVO	2022-09-29 19:01:30.735	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	2	1	9	2	\N
5	ACTIVO	2022-09-29 19:01:30.736	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	2	1	10	2	\N
9	ACTIVO	2022-09-29 23:57:06.3	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	5	2	1	6	3	\N
7	ACTIVO	2022-09-29 23:57:06.3	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	2	1	9	3	\N
8	ACTIVO	2022-09-29 23:57:06.3	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	2	1	10	3	\N
10	ACTIVO	2022-09-30 00:14:03.217	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	5	4	1	7	4	\N
11	ACTIVO	2022-10-11 16:07:57.455	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	4	1	9	5	\N
12	ACTIVO	2022-10-11 16:07:57.455	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	4	1	10	5	\N
13	ACTIVO	2022-10-11 16:07:57.455	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	5	4	1	6	5	\N
14	ACTIVO	2022-10-12 10:07:40.259	FALTA DE ITEMS EN EL DEPOSITO 1 MATRIZ	MANUAL	2	2	5	\N	\N	1
15	ACTIVO	2022-10-12 10:14:48.474	FALTA DE ITEMS	MANUAL	2	4	5	\N	\N	1
16	ACTIVO	2022-10-12 10:15:32.732	FALTA DE ITEMS EN SAN LORENZO	MANUAL	7	2	5	\N	\N	1
17	ACTIVO	2022-10-17 13:24:28.638	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	2	4	1	8	6	1
18	ACTIVO	2022-10-17 15:26:29.136	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	1	1	11	7	1
19	ACTIVO	2022-10-17 15:51:30.976	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	7	1	1	12	8	1
20	ACTIVO	2022-10-17 16:20:52.981	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	2	1	13	9	1
22	ACTIVO	2022-10-18 08:51:29.755	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	1	1	13	10	1
21	ACTIVO	2022-10-18 08:51:29.755	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	5	1	1	14	10	1
23	ACTIVO	2022-10-20 11:17:19.442	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	1	1	16	11	1
24	ACTIVO	2022-10-20 11:27:54.772	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	6	4	1	17	12	1
25	ACTIVO	2022-10-20 11:29:46.844	FALTA MONITOR	MANUAL	8	4	6	\N	\N	1
26	ACTIVO	2022-10-23 21:59:52.311	REMISION AUTOMATICA POR COMPRA	AUTOMATICA	12	4	1	19	13	1
\.


--
-- TOC entry 4016 (class 0 OID 738121)
-- Dependencies: 285
-- Data for Name: nota_remision_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nota_remision_detalle (id, cantidad, estado, id_articulo, id_pedido_compra_detalle, id_nota_remision) FROM stdin;
2	10	ACTIVO	4	8	1
1	10	ACTIVO	7	7	1
3	5	ACTIVO	7	12	2
4	5	ACTIVO	4	11	3
5	5	ACTIVO	4	11	4
8	5	ACTIVO	7	12	5
6	10	ACTIVO	4	8	6
7	10	ACTIVO	7	7	6
9	5	ACTIVO	4	11	7
12	5	ACTIVO	7	12	8
11	10	ACTIVO	4	8	9
10	10	ACTIVO	7	7	9
13	10	ACTIVO	5	9	10
17	5	ACTIVO	4	11	11
14	5	ACTIVO	7	12	12
16	10	ACTIVO	4	8	13
15	10	ACTIVO	7	7	13
19	5	ACTIVO	5	\N	14
18	5	ACTIVO	4	\N	14
20	5	ACTIVO	7	\N	14
22	3	ACTIVO	5	\N	15
23	3	ACTIVO	4	\N	15
21	3	ACTIVO	7	\N	15
24	8	ACTIVO	5	\N	16
25	5	ACTIVO	6	10	17
26	10	ACTIVO	8	13	18
27	10	ACTIVO	4	14	19
28	10	ACTIVO	7	15	19
29	15	ACTIVO	5	16	20
31	5	ACTIVO	5	18	21
30	5	ACTIVO	4	17	21
32	15	ACTIVO	5	16	22
34	5	ACTIVO	6	20	23
33	10	ACTIVO	5	21	23
35	5	ACTIVO	6	22	24
36	2	ACTIVO	6	\N	25
37	10	ACTIVO	9	24	26
\.


--
-- TOC entry 4019 (class 0 OID 738128)
-- Dependencies: 288
-- Data for Name: orden_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orden_compra (id, cantidad_cuota, estado, fecha, intervalo, monto, monto_cuota, observacion, id_condicion_pago, id_estado, id_proveedor, id_usuario) FROM stdin;
1	\N	ACTIVO	2022-09-27 12:11:10.528	\N	850000	\N	NISSEI - MOUSE Y TECLADO	1	2	3	1
3	\N	ACTIVO	2022-09-30 00:12:38.235	\N	350000	\N	TECLADO	1	4	3	1
2	12	ACTIVO	2022-09-27 12:16:27.828	30	750000	62500	MOUSE Y MOUSEPAD	2	4	3	1
4	3	ACTIVO	2022-10-17 11:48:22.925	30	750000	250000	COMPRA MONITOR	2	4	3	1
5	12	ACTIVO	2022-10-17 15:17:33.001	30	1100000	9166666666666668	COMPRA MONITOR LOGITECH	2	2	3	1
6	6	ACTIVO	2022-10-17 15:24:08.175	30	1100000	183333	COMPRA PEDIDO	2	4	3	1
7	\N	ACTIVO	2022-10-17 15:49:08.812	\N	1000000	\N	MOUSE Y MOUSEPAD	1	4	3	1
9	\N	ACTIVO	2022-10-17 15:49:39.387	\N	500000	\N	MOUSE Y TECLADO	1	2	3	1
10	6	ACTIVO	2022-10-17 16:13:40.098	30	500000	83333	MOUSE Y TECLADO	2	2	3	1
8	\N	ACTIVO	2022-10-17 15:49:27.947	\N	750000	\N	TECLADO	1	2	3	1
11	6	ACTIVO	2022-10-18 07:57:27.905	30	880000	146667	COMPRA DE MOUSE Y TECLADO	2	2	3	1
12	\N	ACTIVO	2022-10-18 08:18:51.184	\N	900000	\N	MOUSE	1	1	3	1
13	\N	ACTIVO	2022-10-18 08:19:22.966	\N	380000	\N	TECLADO	1	2	3	1
14	12	ACTIVO	2022-10-18 08:20:26.582	30	880000	73333	MOUSE Y TECLADO	2	4	3	1
15	12	ACTIVO	2022-10-20 11:09:35.685	30	1150000	95833	TECLADO Y MONITOR	2	4	3	1
16	\N	ACTIVO	2022-10-20 11:25:45.179	\N	530000	\N	MONITOR	1	4	3	1
17	6	ACTIVO	2022-10-22 16:21:19.456	30	840000	140000	COMPRA DE MOUSE	2	1	3	1
18	\N	ACTIVO	2022-10-23 21:59:09.093	\N	150000	\N	CABLE SATA	1	4	3	1
\.


--
-- TOC entry 4020 (class 0 OID 738134)
-- Dependencies: 289
-- Data for Name: orden_compra_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orden_compra_detalle (id, estado, monto, id_presupueto_compra_detalle, id_orden_compra) FROM stdin;
1	ACTIVO	300000	5	1
3	ACTIVO	200000	6	1
2	ACTIVO	350000	7	1
7	ACTIVO	300000	5	2
6	ACTIVO	200000	6	2
4	ACTIVO	150000	9	2
5	ACTIVO	100000	10	2
8	ACTIVO	350000	7	3
9	ACTIVO	750000	8	4
10	ACTIVO	1100000	11	5
11	ACTIVO	1100000	11	6
12	ACTIVO	500000	12	7
13	ACTIVO	500000	13	7
14	ACTIVO	750000	14	8
16	ACTIVO	250000	16	9
15	ACTIVO	250000	15	9
17	ACTIVO	250000	16	10
18	ACTIVO	250000	15	10
19	ACTIVO	750000	14	11
20	ACTIVO	250000	16	11
21	ACTIVO	250000	15	11
22	ACTIVO	900000	17	12
23	ACTIVO	750000	14	13
24	ACTIVO	750000	14	14
25	ACTIVO	250000	16	14
26	ACTIVO	250000	15	14
28	ACTIVO	750000	19	15
27	ACTIVO	400000	18	15
29	ACTIVO	800000	20	16
30	ACTIVO	1000000	21	17
31	ACTIVO	150000	22	18
\.


--
-- TOC entry 4023 (class 0 OID 738141)
-- Dependencies: 292
-- Data for Name: orden_servicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orden_servicio (id, estado, fecha, fecha_entrega, observacion, total, vencimiento_garantia, id_estado, id_presupuesto_servicio, id_usuario, id_factura) FROM stdin;
1	ACTIVO	2022-10-23 16:01:10.98	2022-10-26 16:01:10.98	CAMBIAR CABLE	50000	2023-01-21 16:01:10.98	2	5	1	\N
3	ACTIVO	2022-10-23 17:04:55.4	2022-10-26 17:04:55.4	CAMBIO DE CABLE DE DISCO DURO	50000	2023-01-21 17:04:55.4	2	5	1	\N
2	ACTIVO	2022-10-23 17:03:30.404	2022-10-26 17:03:30.404	MANTENIMIENTO DE DOS PC DE ESCRITORIO	360000	2023-01-21 17:03:30.404	2	6	1	\N
4	ACTIVO	2022-10-23 22:02:10.492	2022-10-26 22:02:10.492	CAMBIO DE CABLE DE DISCO DURO	50000	2023-01-21 22:02:10.492	1	5	1	3
5	ACTIVO	2022-10-29 09:08:35.977	2022-11-01 09:08:35.977	MANTENMIENTO	360000	2023-01-27 09:08:35.977	1	6	1	\N
\.


--
-- TOC entry 4024 (class 0 OID 738147)
-- Dependencies: 293
-- Data for Name: orden_servicio_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orden_servicio_detalle (id, estado, monto, id_presupueto_servicio_detalle, id_orden_servicio) FROM stdin;
1	ACTIVO	50000	8	1
2	ACTIVO	240000	10	2
3	ACTIVO	120000	9	2
4	ACTIVO	50000	8	3
5	ACTIVO	50000	8	4
7	ACTIVO	240000	10	5
6	ACTIVO	120000	9	5
\.


--
-- TOC entry 4027 (class 0 OID 738154)
-- Dependencies: 296
-- Data for Name: pago; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pago (id, descripcion, estado, fecha, monto) FROM stdin;
1	PAGO GENERADO PARA NOTA DE DEBITO NRO: 39	ACTIVO	2022-10-14 10:48:08.966	62500
2	PAGO GENERADO PARA NOTA DE DEBITO NRO: 42	ACTIVO	2022-10-14 10:53:14.492	62500
3	PAGO GENERADO PARA NOTA DE DEBITO NRO: 80	ACTIVO	2022-10-20 11:22:31.491	95833
4	PAGO GENERADO PARA NOTA DE DEBITO NRO: 37	ACTIVO	2022-10-22 16:15:32.425	350000
\.


--
-- TOC entry 4029 (class 0 OID 738162)
-- Dependencies: 298
-- Data for Name: pedido_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido_compra (id, estado, fecha, id_deposito, id_estado, id_usuario, observacion) FROM stdin;
4	ACTIVO	2022-09-22 10:19:24.638	2	2	1	PEDIDO
6	ACTIVO	2022-09-27 10:57:49.026	5	4	1	MOUSEPAD Y MOUSE
7	ACTIVO	2022-09-27 10:58:44.402	5	4	1	TECLADO
8	ACTIVO	2022-09-27 10:59:13.889	2	4	1	MONITOR
9	ACTIVO	2022-09-27 11:27:47.862	6	4	1	MOUSE
10	ACTIVO	2022-09-27 11:28:12.253	6	4	1	MOUSEPAD
2	ACTIVO	2022-09-22 09:48:37.077	6	2	1	PEDIDO
3	ACTIVO	2022-09-22 10:13:34.835	8	2	1	OTRO PEDIDO
5	ACTIVO	2022-09-22 14:05:01.386	8	2	1	PEDIDO
1	ACTIVO	2022-09-22 00:32:36.102	2	2	1	PEDIDO DE PRUEBA
11	ACTIVO	2022-10-17 15:02:08.201	6	4	1	PEDIDO  MOUSE LOGITECH
12	ACTIVO	2022-10-17 15:46:23.557	7	4	1	MOUSE Y MOUSE PAD
13	ACTIVO	2022-10-17 15:46:58.156	6	4	1	TECLADO
14	ACTIVO	2022-10-17 15:47:20.764	5	4	1	MOUSE Y TECLADO
15	ACTIVO	2022-10-18 08:18:10.43	5	4	1	MOUSE
16	ACTIVO	2022-10-20 10:52:56.544	6	4	1	PEDIDO MONITOR Y TECLADO
17	ACTIVO	2022-10-20 11:24:59.891	6	4	1	MONITO
18	ACTIVO	2022-10-21 10:14:09.651	10	4	1	MOUSE LOGITECH
19	ACTIVO	2022-10-23 21:57:44.528	12	4	1	COMPRA CABLE SATA
\.


--
-- TOC entry 3961 (class 0 OID 737929)
-- Dependencies: 230
-- Data for Name: pedido_compra_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido_compra_detalle (id, cantidad, estado, id_articulo, id_pedido_compra) FROM stdin;
1	1	ACTIVO	2	1
2	3	ACTIVO	2	2
3	2	ACTIVO	2	3
4	3	ACTIVO	3	4
6	1	ACTIVO	2	5
5	2	ACTIVO	3	5
8	10	ACTIVO	4	6
7	10	ACTIVO	7	6
9	10	ACTIVO	5	7
10	5	ACTIVO	6	8
11	5	ACTIVO	4	9
12	5	ACTIVO	7	10
13	10	ACTIVO	8	11
14	10	ACTIVO	4	12
15	10	ACTIVO	7	12
16	15	ACTIVO	5	13
18	5	ACTIVO	5	14
17	5	ACTIVO	4	14
19	20	ACTIVO	4	15
20	5	ACTIVO	6	16
21	10	ACTIVO	5	16
22	5	ACTIVO	6	17
23	10	ACTIVO	8	18
24	10	ACTIVO	9	19
\.


--
-- TOC entry 4031 (class 0 OID 738170)
-- Dependencies: 300
-- Data for Name: pedido_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido_venta (id, estado, fecha, observacion, id_deposito, id_estado, id_usuario, id_cliente) FROM stdin;
1	ACTIVO	2022-10-14 16:48:55.545	COMPRA DE MOUSE Y MOUSEPAD JULIO QUINTANA	6	2	1	1
2	ACTIVO	2022-10-26 16:43:35.766	VENTA MONITOR	8	2	1	1
\.


--
-- TOC entry 4032 (class 0 OID 738176)
-- Dependencies: 301
-- Data for Name: pedido_venta_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido_venta_detalle (id, cantidad, estado, id_articulo, id_pedido_venta) FROM stdin;
1	1	ACTIVO	4	1
2	1	ACTIVO	7	1
3	1	ACTIVO	6	2
\.


--
-- TOC entry 4035 (class 0 OID 738183)
-- Dependencies: 304
-- Data for Name: permiso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permiso (id, id_rol, id_formulario, agregar, modificar, eliminar, consultar, listar, informe, exportar, id_usuario_auditoria, estado, reactivar, anular) FROM stdin;
1	1	1	t	t	t	t	t	t	t	1	ACTIVO	t	t
2	1	2	t	t	t	t	t	t	t	1	ACTIVO	t	t
3	1	3	t	t	t	t	t	t	t	1	ACTIVO	t	t
4	1	4	t	t	t	t	t	t	t	1	ACTIVO	t	t
5	1	5	t	t	t	t	t	t	t	1	ACTIVO	t	t
6	1	6	t	t	t	t	t	t	t	1	ACTIVO	t	t
7	1	7	t	t	t	t	t	t	t	1	ACTIVO	t	t
8	1	8	t	t	t	t	t	t	t	1	ACTIVO	t	t
9	1	9	t	t	t	t	t	t	t	1	ACTIVO	t	t
10	1	10	t	t	t	t	t	t	t	1	ACTIVO	t	t
11	1	11	t	t	t	t	t	t	t	1	ACTIVO	t	t
12	1	12	t	t	t	t	t	t	t	1	ACTIVO	t	t
13	1	13	t	t	t	t	t	t	t	1	ACTIVO	t	t
14	1	14	t	t	t	t	t	t	t	1	ACTIVO	t	t
15	1	15	t	t	t	t	t	t	t	1	ACTIVO	t	t
16	1	16	t	t	t	t	t	t	t	1	ACTIVO	t	t
17	1	17	t	t	t	t	t	t	t	1	ACTIVO	t	t
18	1	18	t	t	t	t	t	t	t	1	ACTIVO	t	t
19	1	19	t	t	t	t	t	t	t	1	ACTIVO	t	t
20	1	20	t	t	t	t	t	t	t	1	ACTIVO	t	t
21	1	21	t	t	t	t	t	t	t	1	ACTIVO	t	t
22	1	22	t	t	t	t	t	t	t	1	ACTIVO	t	t
23	1	23	t	t	t	t	t	t	t	1	ACTIVO	t	t
24	1	24	t	t	t	t	t	t	t	1	ACTIVO	t	t
25	1	25	t	t	t	t	t	t	t	1	ACTIVO	t	t
26	1	26	t	t	t	t	t	t	t	1	ACTIVO	t	t
27	1	27	t	t	t	t	t	t	t	1	ACTIVO	t	t
28	1	28	t	t	t	t	t	t	t	1	ACTIVO	t	t
29	1	29	t	t	t	t	t	t	t	1	ACTIVO	t	t
30	1	30	t	t	t	t	t	t	t	1	ACTIVO	t	t
31	1	31	t	t	t	t	t	t	t	1	ACTIVO	t	t
32	1	32	t	t	t	t	t	t	t	1	ACTIVO	t	t
33	1	33	t	t	t	t	t	t	t	1	ACTIVO	t	t
34	1	34	t	t	t	t	t	t	t	1	ACTIVO	t	t
35	1	35	t	t	t	t	t	t	t	1	ACTIVO	t	t
36	1	36	t	t	t	t	t	t	t	1	ACTIVO	t	t
37	1	37	t	t	t	t	t	t	t	1	ACTIVO	t	t
38	1	38	t	t	t	t	t	t	t	1	ACTIVO	t	t
39	1	39	t	t	t	t	t	t	t	1	ACTIVO	t	t
40	1	40	t	t	t	t	t	t	t	1	ACTIVO	t	t
41	1	41	t	t	t	t	t	t	t	1	ACTIVO	t	t
42	1	42	t	t	t	t	t	t	t	1	ACTIVO	t	t
212	3	21	t	t	t	t	t	t	t	\N	ACTIVO	t	t
43	1	43	t	t	t	t	t	t	t	1	ACTIVO	t	t
62	5	9	t	t	t	t	t	t	t	\N	ACTIVO	t	t
63	5	10	t	t	t	t	t	t	t	\N	ACTIVO	t	t
64	5	11	t	t	t	t	t	t	t	\N	ACTIVO	t	t
65	5	23	t	t	t	t	t	t	t	\N	ACTIVO	t	t
66	5	38	t	t	t	t	t	t	t	\N	ACTIVO	t	t
67	5	22	t	t	t	t	t	t	t	\N	ACTIVO	t	t
68	5	33	t	t	t	t	t	t	t	\N	ACTIVO	t	t
69	5	34	t	t	t	t	t	t	t	\N	ACTIVO	t	t
70	5	37	t	t	t	t	t	t	t	\N	ACTIVO	t	t
71	5	39	t	t	t	t	t	t	t	\N	ACTIVO	t	t
72	5	40	t	t	t	t	t	t	t	\N	ACTIVO	t	t
88	3	24	t	t	t	t	t	t	t	\N	ACTIVO	t	t
214	3	25	t	t	t	t	t	t	t	\N	ACTIVO	t	t
233	46	1	t	t	t	t	t	t	t	\N	ACTIVO	t	t
234	46	26	t	t	t	t	t	t	t	\N	ACTIVO	t	t
235	46	27	t	t	t	t	t	t	t	\N	ACTIVO	t	t
236	46	28	t	t	t	t	t	t	t	\N	ACTIVO	t	t
195	3	37	t	t	t	t	t	t	t	\N	INACTIVO	t	t
237	46	29	t	t	t	t	t	t	t	\N	ACTIVO	t	t
229	3	31	t	t	t	t	t	t	t	\N	INACTIVO	t	t
238	46	35	t	t	t	t	t	t	t	\N	ACTIVO	t	t
228	3	30	t	t	t	t	t	t	t	\N	INACTIVO	t	t
239	46	36	t	t	t	t	t	t	t	\N	ACTIVO	t	t
230	3	29	t	t	t	t	t	t	t	\N	INACTIVO	t	t
174	3	26	t	t	t	t	t	t	t	\N	INACTIVO	t	t
231	3	23	t	t	t	t	t	t	t	\N	INACTIVO	t	t
198	3	2	t	t	t	t	t	t	t	\N	ACTIVO	t	t
74	3	3	t	t	t	t	t	t	t	\N	ACTIVO	t	t
187	3	4	t	t	t	t	t	t	t	\N	ACTIVO	t	t
232	3	5	t	t	t	t	t	t	t	\N	ACTIVO	t	t
202	3	6	t	t	t	t	t	t	t	\N	ACTIVO	t	t
203	3	12	t	t	t	t	t	t	t	\N	ACTIVO	t	t
219	3	13	t	t	t	t	t	t	t	\N	ACTIVO	t	t
220	3	14	t	t	t	t	t	t	t	\N	ACTIVO	t	t
81	3	15	t	t	t	t	t	t	t	\N	ACTIVO	t	t
82	3	16	t	t	t	t	t	t	t	\N	ACTIVO	t	t
194	3	34	t	t	t	t	t	t	t	\N	INACTIVO	t	t
193	3	33	t	t	t	t	t	t	t	\N	INACTIVO	t	t
196	3	39	t	t	t	t	t	t	t	\N	INACTIVO	t	t
208	3	17	t	t	t	t	t	t	t	\N	ACTIVO	t	t
197	3	40	t	t	t	t	t	t	t	\N	INACTIVO	t	t
192	3	22	t	t	t	t	t	t	t	\N	INACTIVO	t	t
209	3	18	t	t	t	t	t	t	t	\N	ACTIVO	t	t
225	3	19	t	t	t	t	t	t	t	\N	ACTIVO	t	t
181	3	20	t	t	t	t	t	t	t	\N	ACTIVO	t	t
\.


--
-- TOC entry 3967 (class 0 OID 737950)
-- Dependencies: 236
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (id, nombre, apellido, ci, telefono, direccion, id_ciudad, estado) FROM stdin;
\.


--
-- TOC entry 4037 (class 0 OID 738191)
-- Dependencies: 306
-- Data for Name: presupuesto_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.presupuesto_compra (id, estado, fecha, observacion, total, id_estado, id_pedido_compra, id_usuario, id_proveedor, id_orden_compra) FROM stdin;
2	ACTIVO	2022-09-23 01:02:04.672	CHAU	150000	2	2	1	4	\N
3	ACTIVO	2022-09-23 01:22:58.261	PRUEBA	50000	2	3	1	3	\N
5	ACTIVO	2022-09-27 11:00:40.44	MOUSE Y MOUSEPAD	500000	4	6	1	3	2
8	ACTIVO	2022-09-27 11:28:37.343	MOUSE	150000	4	9	1	3	2
9	ACTIVO	2022-09-27 11:28:56.935	MOUSEPAD	100000	4	10	1	3	2
6	ACTIVO	2022-09-27 11:05:12.3	TECLADO	350000	4	7	1	3	3
7	ACTIVO	2022-09-27 11:05:43.027	MONITOR	750000	4	8	1	3	4
4	ACTIVO	2022-09-23 01:33:04.709	OTRA PRUEBA	45000	2	1	1	5	\N
10	ACTIVO	2022-10-17 15:03:39.108	PEDIDO CENTRO MOUSE LOGITECH	1100000	4	11	1	3	6
11	ACTIVO	2022-10-17 15:47:55.668	MOUSE Y MOUSEPAD	1000000	4	12	1	3	7
14	ACTIVO	2022-10-18 08:18:31.519	MOUSE	900000	4	15	1	3	12
12	ACTIVO	2022-10-17 15:48:27.636	TECLADO	750000	4	13	1	3	14
13	ACTIVO	2022-10-17 15:48:43.272	MOUSE Y TECLADO	500000	4	14	1	3	14
15	ACTIVO	2022-10-20 11:07:23.14	PRESUPUESTO TECLADO MONIITOR	1150000	4	16	1	3	15
16	ACTIVO	2022-10-20 11:25:23.511	MONITOR	800000	4	17	1	3	16
17	ACTIVO	2022-10-22 16:20:32.357	COMPRA MOUSE	1000000	4	18	1	3	17
18	ACTIVO	2022-10-23 21:58:15.815	CABLE SATA	150000	4	19	1	3	18
\.


--
-- TOC entry 4038 (class 0 OID 738197)
-- Dependencies: 307
-- Data for Name: presupuesto_compra_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.presupuesto_compra_detalle (id, estado, monto, id_pedido_compra_detalle, id_presuesto_compra) FROM stdin;
2	ACTIVO	50000	2	2
3	ACTIVO	25000	3	3
4	ACTIVO	45000	1	4
5	ACTIVO	30000	8	5
6	ACTIVO	20000	7	5
7	ACTIVO	35000	9	6
8	ACTIVO	150000	10	7
9	ACTIVO	30000	11	8
10	ACTIVO	20000	12	9
11	ACTIVO	110000	13	10
12	ACTIVO	50000	14	11
13	ACTIVO	50000	15	11
14	ACTIVO	50000	16	12
16	ACTIVO	50000	18	13
15	ACTIVO	50000	17	13
17	ACTIVO	45000	19	14
19	ACTIVO	150000	20	15
18	ACTIVO	40000	21	15
20	ACTIVO	160000	22	16
21	ACTIVO	100000	23	17
22	ACTIVO	15000	24	18
\.


--
-- TOC entry 4041 (class 0 OID 738204)
-- Dependencies: 310
-- Data for Name: presupuesto_servicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.presupuesto_servicio (id, estado, fecha, observacion, total, id_diagnostico, id_estado, id_promo_descuento, id_usuario) FROM stdin;
1	ACTIVO	2022-10-22 11:52:34.461	MANTENIMIENTO	240000	6	2	2	1
2	ACTIVO	2022-10-22 16:02:38.646	MANTENIMIENTO	360000	9	2	2	1
3	ACTIVO	2022-10-22 17:50:19.775	CAMBIO DE CABLE CON DESCUENTO 10%	50000	10	2	2	1
4	ACTIVO	2022-10-22 17:52:08.196	MANTENIMIENTO	360000	9	2	4	1
5	ACTIVO	2022-10-23 13:54:39.36	CAMBIO DE CABLE	50000	10	4	2	1
6	ACTIVO	2022-10-23 13:55:23.242	MANTENIMIENTO DE 2 MAQUINAS	360000	9	4	2	1
\.


--
-- TOC entry 4042 (class 0 OID 738210)
-- Dependencies: 311
-- Data for Name: presupuesto_servicio_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.presupuesto_servicio_detalle (id, estado, monto, id_diagnostico_detalle, id_presuesto_servicio) FROM stdin;
1	ACTIVO	0	10	1
2	ACTIVO	0	9	1
4	ACTIVO	0	14	2
3	ACTIVO	0	15	2
5	ACTIVO	0	16	3
7	ACTIVO	0	14	4
6	ACTIVO	0	15	4
8	ACTIVO	50000	16	5
10	ACTIVO	240000	14	6
9	ACTIVO	120000	15	6
\.


--
-- TOC entry 4045 (class 0 OID 738217)
-- Dependencies: 314
-- Data for Name: promo_descuento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.promo_descuento (id, descripcion, estado, porcentaje) FROM stdin;
1	DESCUENTO NORMAL	ACTIVO	5
2	DESCUENTO AMIGO	ACTIVO	10
3	PRUEBA	INACTIVO	0
4	SIN DESCUENTO	ACTIVO	0
\.


--
-- TOC entry 4047 (class 0 OID 738225)
-- Dependencies: 316
-- Data for Name: proveedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.proveedor (id, razon_social, ruc, telefono, correo, direccion, id_ciudad, estado) FROM stdin;
3	NISSEI	3739033	9094545	HOLA@NISSEI.COM.PY	BLABLA ESQ BLALA	1	ACTIVO
4	HP STORE	1561135	02123123	HOLA@HP.COM.PY	CALLE ESQ. AVENIDA	1	ACTIVO
5	COMPUMARKET	45132156	05151321	CONTACTO@COMPUMARKET.COM.PY	CALLE 999	2	ACTIVO
\.


--
-- TOC entry 4050 (class 0 OID 738235)
-- Dependencies: 319
-- Data for Name: recepcion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.recepcion (id, estado, fecha, observacion, id_estado, id_usuario, id_sucursal, id_cliente) FROM stdin;
1	ACTIVO	2022-10-19 14:28:50.832	MANTENIMIENTO HARDWARE	2	1	6	1
2	ACTIVO	2022-10-19 14:39:46.69	MANTENIMIENTO	2	1	5	1
4	ACTIVO	2022-10-21 14:49:48.94	MANTENIMIENTO SOFTWARE	2	1	14	1
3	ACTIVO	2022-10-19 14:41:14.398	MANTENIMIENTO HARDWARE	2	1	14	1
5	ACTIVO	2022-10-21 14:51:02.668	MANTENIMIENTO COMPLETO	2	1	14	1
7	ACTIVO	2022-10-22 10:45:53.811	MOUSE	1	1	14	1
6	ACTIVO	2022-10-22 09:27:44.256	MANTEMIENTO 2 PC	4	1	14	1
8	ACTIVO	2022-10-22 17:40:16.51	PC NO ANDA DISCO	4	1	14	1
\.


--
-- TOC entry 4051 (class 0 OID 738241)
-- Dependencies: 320
-- Data for Name: recepcion_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.recepcion_detalle (id, estado, id_equipo, id_recepcion) FROM stdin;
1	ACTIVO	11	1
2	ACTIVO	4	2
3	ACTIVO	4	3
4	ACTIVO	10	4
5	ACTIVO	4	5
6	ACTIVO	10	5
7	ACTIVO	4	6
8	ACTIVO	10	6
9	ACTIVO	18	7
10	ACTIVO	13	8
\.


--
-- TOC entry 4054 (class 0 OID 738248)
-- Dependencies: 323
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rol (id, nombre, id_usuario_auditoria, estado) FROM stdin;
1	ADMINISTRADOR	\N	ACTIVO
2	CAJERO	\N	ACTIVO
3	AYUDANTE COMPRAS	\N	ACTIVO
46	VENDEDOR	\N	ACTIVO
5	VENDEDOR_2	\N	ACTIVO
\.


--
-- TOC entry 4056 (class 0 OID 738256)
-- Dependencies: 325
-- Data for Name: servicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.servicio (id, descripcion, estado, monto, id_impuesto, id_articulo) FROM stdin;
1	MANTENIMIENTO - HARDWARE	ACTIVO	120000	2	\N
2	PRUEBA	INACTIVO	40000	2	\N
3	MANTENIMIENTO - SOFTWARE	ACTIVO	120000	2	\N
4	REPARACION DISPLAY	ACTIVO	150000	2	\N
7	REPARACION MOUSE	ACTIVO	100000	2	\N
8	CAMBIO CABLE SATA	ACTIVO	25000	2	9
\.


--
-- TOC entry 4058 (class 0 OID 738264)
-- Dependencies: 327
-- Data for Name: servicios_por_diagnostico_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.servicios_por_diagnostico_detalle (id_diagnostico_detalle, id_servicio) FROM stdin;
7	3
8	1
9	3
10	1
11	7
12	1
13	3
14	1
14	3
15	1
16	8
\.


--
-- TOC entry 4059 (class 0 OID 738267)
-- Dependencies: 328
-- Data for Name: sistema; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sistema (id, nombre, id_usuario_auditoria, estado) FROM stdin;
1	Administración	\N	ACTIVO
2	Servicio	\N	ACTIVO
3	Venta	\N	ACTIVO
4	Compras	\N	ACTIVO
\.


--
-- TOC entry 4061 (class 0 OID 738275)
-- Dependencies: 330
-- Data for Name: stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.stock (id, estado, existencia, id_articulo, id_deposito) FROM stdin;
6	ACTIVO	5	7	6
4	ACTIVO	7	5	5
9	ACTIVO	3	5	2
7	ACTIVO	7	4	5
10	ACTIVO	3	4	2
8	ACTIVO	7	7	5
11	ACTIVO	3	7	2
5	ACTIVO	4	4	6
13	ACTIVO	5	6	2
14	ACTIVO	8	8	1
2	ACTIVO	8	7	1
1	ACTIVO	14	4	1
3	ACTIVO	27	5	1
15	ACTIVO	3	6	6
12	ACTIVO	3	6	1
17	ACTIVO	0	9	1
18	ACTIVO	9	9	12
16	ACTIVO	2	6	8
\.


--
-- TOC entry 4063 (class 0 OID 738280)
-- Dependencies: 332
-- Data for Name: sub_menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sub_menu (id, nombre, id_usuario_auditoria, estado) FROM stdin;
2	Procesos	\N	ACTIVO
3	Reportes	\N	ACTIVO
1	Referenciales	\N	ACTIVO
\.


--
-- TOC entry 4065 (class 0 OID 738288)
-- Dependencies: 334
-- Data for Name: sucursal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sucursal (id, descripcion, estado, id_ciudad) FROM stdin;
2	SAN LORENZO	ACTIVO	2
5	FERNANDO DE LA MORA	ACTIVO	5
6	CENTRO	ACTIVO	1
7	MATRIZ	ACTIVO	3
14	ÑEMBY	ACTIVO	6
\.


--
-- TOC entry 4067 (class 0 OID 738296)
-- Dependencies: 336
-- Data for Name: tarjeta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tarjeta (id, descripcion, estado) FROM stdin;
2	Mastercard	ACTIVO
1	Visa	ACTIVO
\.


--
-- TOC entry 4086 (class 0 OID 739295)
-- Dependencies: 355
-- Data for Name: timbrado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.timbrado (id, estado, inicio_vigencia, fin_vigencia, numero) FROM stdin;
1	INACTIVO	2022-10-31	2023-10-31	1234567
2	ACTIVO	2022-10-28	2023-10-28	12345678
\.


--
-- TOC entry 4069 (class 0 OID 738310)
-- Dependencies: 338
-- Data for Name: tipo_articulo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_articulo (id, descripcion, estado) FROM stdin;
1	SUMINISTRO	ACTIVO
2	REPUESTO	ACTIVO
3	ART P/VENTA	ACTIVO
\.


--
-- TOC entry 4071 (class 0 OID 738318)
-- Dependencies: 340
-- Data for Name: tipo_cheque; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_cheque (id, descripcion, estado) FROM stdin;
\.


--
-- TOC entry 4073 (class 0 OID 738326)
-- Dependencies: 342
-- Data for Name: tipo_documento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_documento (id, descripcion, estado) FROM stdin;
\.


--
-- TOC entry 4075 (class 0 OID 738334)
-- Dependencies: 344
-- Data for Name: tipo_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_item (id, descripcion, estado) FROM stdin;
\.


--
-- TOC entry 4077 (class 0 OID 738342)
-- Dependencies: 346
-- Data for Name: tipo_problema; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_problema (id, descripcion, estado) FROM stdin;
1	prueba1	ACTIVO
\.


--
-- TOC entry 4079 (class 0 OID 738350)
-- Dependencies: 348
-- Data for Name: tipo_tarjeta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_tarjeta (id, descripcion, estado) FROM stdin;
1	PRUEBAS	INACTIVO
2	DEBITO	ACTIVO
3	CREDITO	ACTIVO
\.


--
-- TOC entry 4081 (class 0 OID 738358)
-- Dependencies: 350
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, nombre, usuario, clave, imagen, id_usuario_auditoria, estado, id_sucursal, intentos_fallidos) FROM stdin;
1	Administrador	admin	c4ca4238a0b923820dcc509a6f75849b	image.jpg	\N	ACTIVO	\N	\N
\.


--
-- TOC entry 4082 (class 0 OID 738364)
-- Dependencies: 351
-- Data for Name: usuario_rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario_rol (id, id_usuario, id_rol, id_usuario_auditoria, estado) FROM stdin;
1	1	1	\N	ACTIVO
9	1	2	\N	ACTIVO
\.


--
-- TOC entry 4169 (class 0 OID 0)
-- Dependencies: 203
-- Name: ajuste_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ajuste_id_seq', 3, true);


--
-- TOC entry 4170 (class 0 OID 0)
-- Dependencies: 205
-- Name: apertura_cierre_caja_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.apertura_cierre_caja_id_seq', 2, true);


--
-- TOC entry 4171 (class 0 OID 0)
-- Dependencies: 207
-- Name: articulo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.articulo_id_seq', 10, true);


--
-- TOC entry 4172 (class 0 OID 0)
-- Dependencies: 209
-- Name: banco_banco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.banco_banco_id_seq', 2, true);


--
-- TOC entry 4173 (class 0 OID 0)
-- Dependencies: 211
-- Name: banco_cheque_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.banco_cheque_id_seq', 1, false);


--
-- TOC entry 4174 (class 0 OID 0)
-- Dependencies: 213
-- Name: caja_caja_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.caja_caja_id_seq', 11, true);


--
-- TOC entry 4175 (class 0 OID 0)
-- Dependencies: 215
-- Name: cargo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cargo_id_seq', 3, true);


--
-- TOC entry 4176 (class 0 OID 0)
-- Dependencies: 217
-- Name: ciudad_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ciudad_id_seq', 6, true);


--
-- TOC entry 4177 (class 0 OID 0)
-- Dependencies: 219
-- Name: cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_seq', 2, true);


--
-- TOC entry 4178 (class 0 OID 0)
-- Dependencies: 221
-- Name: cobro_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cobro_id_seq', 1, false);


--
-- TOC entry 4179 (class 0 OID 0)
-- Dependencies: 223
-- Name: condicion_pago_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.condicion_pago_id_seq', 3, true);


--
-- TOC entry 4180 (class 0 OID 0)
-- Dependencies: 225
-- Name: cuenta_a_cobrar_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cuenta_a_cobrar_id_seq', 1, false);


--
-- TOC entry 4181 (class 0 OID 0)
-- Dependencies: 227
-- Name: cuenta_a_pagar_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cuenta_a_pagar_id_seq', 86, true);


--
-- TOC entry 4182 (class 0 OID 0)
-- Dependencies: 228
-- Name: deposito_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.deposito_id_seq', 12, true);


--
-- TOC entry 4183 (class 0 OID 0)
-- Dependencies: 231
-- Name: detalle_pedido_compra_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detalle_pedido_compra_id_seq', 24, true);


--
-- TOC entry 4184 (class 0 OID 0)
-- Dependencies: 234
-- Name: diagnostico_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.diagnostico_detalle_id_seq', 16, true);


--
-- TOC entry 4185 (class 0 OID 0)
-- Dependencies: 235
-- Name: diagnostico_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.diagnostico_id_seq', 10, true);


--
-- TOC entry 4186 (class 0 OID 0)
-- Dependencies: 237
-- Name: empleado_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.empleado_id_seq', 1, false);


--
-- TOC entry 4187 (class 0 OID 0)
-- Dependencies: 239
-- Name: empresa_empre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.empresa_empre_id_seq', 6, true);


--
-- TOC entry 4188 (class 0 OID 0)
-- Dependencies: 241
-- Name: encargado_enca_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.encargado_enca_id_seq', 3, true);


--
-- TOC entry 4189 (class 0 OID 0)
-- Dependencies: 243
-- Name: entidad_emisora_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.entidad_emisora_id_seq', 2, true);


--
-- TOC entry 4190 (class 0 OID 0)
-- Dependencies: 245
-- Name: equipos_equi_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.equipos_equi_id_seq', 18, true);


--
-- TOC entry 4191 (class 0 OID 0)
-- Dependencies: 247
-- Name: estado_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estado_id_seq', 9, true);


--
-- TOC entry 4192 (class 0 OID 0)
-- Dependencies: 251
-- Name: factura_compra_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.factura_compra_detalle_id_seq', 29, true);


--
-- TOC entry 4193 (class 0 OID 0)
-- Dependencies: 252
-- Name: factura_compra_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.factura_compra_id_seq', 13, true);


--
-- TOC entry 4194 (class 0 OID 0)
-- Dependencies: 254
-- Name: factura_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.factura_detalle_id_seq', 6, true);


--
-- TOC entry 4195 (class 0 OID 0)
-- Dependencies: 255
-- Name: factura_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.factura_id_seq', 3, true);


--
-- TOC entry 4196 (class 0 OID 0)
-- Dependencies: 257
-- Name: forma_cobro_form_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.forma_cobro_form_id_seq', 4, true);


--
-- TOC entry 4197 (class 0 OID 0)
-- Dependencies: 259
-- Name: formularios_id_formulario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.formularios_id_formulario_seq', 60, true);


--
-- TOC entry 4198 (class 0 OID 0)
-- Dependencies: 261
-- Name: impuesto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.impuesto_id_seq', 4, true);


--
-- TOC entry 4199 (class 0 OID 0)
-- Dependencies: 263
-- Name: items_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.items_item_id_seq', 3, true);


--
-- TOC entry 4200 (class 0 OID 0)
-- Dependencies: 266
-- Name: libro_compra_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.libro_compra_detalle_id_seq', 29, true);


--
-- TOC entry 4201 (class 0 OID 0)
-- Dependencies: 267
-- Name: libro_compra_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.libro_compra_id_seq', 13, true);


--
-- TOC entry 4202 (class 0 OID 0)
-- Dependencies: 270
-- Name: libro_venta_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.libro_venta_detalle_id_seq', 6, true);


--
-- TOC entry 4203 (class 0 OID 0)
-- Dependencies: 271
-- Name: libro_venta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.libro_venta_id_seq', 3, true);


--
-- TOC entry 4204 (class 0 OID 0)
-- Dependencies: 273
-- Name: marcas_mar_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marcas_mar_id_seq', 38, true);


--
-- TOC entry 4205 (class 0 OID 0)
-- Dependencies: 275
-- Name: motivo_ajuste_maju_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.motivo_ajuste_maju_id_seq', 2, true);


--
-- TOC entry 4206 (class 0 OID 0)
-- Dependencies: 278
-- Name: nota_credito_compra_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nota_credito_compra_detalle_id_seq', 8, true);


--
-- TOC entry 4207 (class 0 OID 0)
-- Dependencies: 279
-- Name: nota_credito_compra_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nota_credito_compra_id_seq', 6, true);


--
-- TOC entry 4208 (class 0 OID 0)
-- Dependencies: 282
-- Name: nota_debito_compra_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nota_debito_compra_detalle_id_seq', 219, true);


--
-- TOC entry 4209 (class 0 OID 0)
-- Dependencies: 283
-- Name: nota_debito_compra_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nota_debito_compra_id_seq', 86, true);


--
-- TOC entry 4210 (class 0 OID 0)
-- Dependencies: 286
-- Name: nota_remision_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nota_remision_detalle_id_seq', 37, true);


--
-- TOC entry 4211 (class 0 OID 0)
-- Dependencies: 287
-- Name: nota_remision_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nota_remision_id_seq', 26, true);


--
-- TOC entry 4212 (class 0 OID 0)
-- Dependencies: 290
-- Name: orden_compra_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_compra_detalle_id_seq', 31, true);


--
-- TOC entry 4213 (class 0 OID 0)
-- Dependencies: 291
-- Name: orden_compra_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_compra_id_seq', 18, true);


--
-- TOC entry 4214 (class 0 OID 0)
-- Dependencies: 294
-- Name: orden_servicio_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_servicio_detalle_id_seq', 7, true);


--
-- TOC entry 4215 (class 0 OID 0)
-- Dependencies: 295
-- Name: orden_servicio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_servicio_id_seq', 5, true);


--
-- TOC entry 4216 (class 0 OID 0)
-- Dependencies: 297
-- Name: pago_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pago_id_seq', 4, true);


--
-- TOC entry 4217 (class 0 OID 0)
-- Dependencies: 299
-- Name: pedido_compra_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_compra_id_seq', 19, true);


--
-- TOC entry 4218 (class 0 OID 0)
-- Dependencies: 302
-- Name: pedido_venta_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_venta_detalle_id_seq', 3, true);


--
-- TOC entry 4219 (class 0 OID 0)
-- Dependencies: 303
-- Name: pedido_venta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_venta_id_seq', 2, true);


--
-- TOC entry 4220 (class 0 OID 0)
-- Dependencies: 305
-- Name: permisos_id_permiso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.permisos_id_permiso_seq', 239, true);


--
-- TOC entry 4221 (class 0 OID 0)
-- Dependencies: 308
-- Name: presupuesto_compra_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.presupuesto_compra_detalle_id_seq', 22, true);


--
-- TOC entry 4222 (class 0 OID 0)
-- Dependencies: 309
-- Name: presupuesto_compra_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.presupuesto_compra_id_seq', 18, true);


--
-- TOC entry 4223 (class 0 OID 0)
-- Dependencies: 312
-- Name: presupuesto_servicio_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.presupuesto_servicio_detalle_id_seq', 10, true);


--
-- TOC entry 4224 (class 0 OID 0)
-- Dependencies: 313
-- Name: presupuesto_servicio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.presupuesto_servicio_id_seq', 6, true);


--
-- TOC entry 4225 (class 0 OID 0)
-- Dependencies: 315
-- Name: promo_descuento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.promo_descuento_id_seq', 4, true);


--
-- TOC entry 4226 (class 0 OID 0)
-- Dependencies: 317
-- Name: proveedor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.proveedor_id_seq', 1, false);


--
-- TOC entry 4227 (class 0 OID 0)
-- Dependencies: 318
-- Name: proveedores_prove_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.proveedores_prove_id_seq', 5, true);


--
-- TOC entry 4228 (class 0 OID 0)
-- Dependencies: 321
-- Name: recepcion_detalle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.recepcion_detalle_id_seq', 10, true);


--
-- TOC entry 4229 (class 0 OID 0)
-- Dependencies: 322
-- Name: recepcion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.recepcion_id_seq', 8, true);


--
-- TOC entry 4230 (class 0 OID 0)
-- Dependencies: 324
-- Name: roles_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_rol_seq', 5, true);


--
-- TOC entry 4231 (class 0 OID 0)
-- Dependencies: 326
-- Name: servicio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.servicio_id_seq', 8, true);


--
-- TOC entry 4232 (class 0 OID 0)
-- Dependencies: 329
-- Name: sistemas_id_sistema_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sistemas_id_sistema_seq', 3, true);


--
-- TOC entry 4233 (class 0 OID 0)
-- Dependencies: 331
-- Name: stock_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.stock_id_seq', 18, true);


--
-- TOC entry 4234 (class 0 OID 0)
-- Dependencies: 333
-- Name: submenus_id_submenu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.submenus_id_submenu_seq', 1, false);


--
-- TOC entry 4235 (class 0 OID 0)
-- Dependencies: 335
-- Name: sucursales_suc_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sucursales_suc_id_seq', 14, true);


--
-- TOC entry 4236 (class 0 OID 0)
-- Dependencies: 337
-- Name: tarjeta_tarjeta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tarjeta_tarjeta_id_seq', 2, true);


--
-- TOC entry 4237 (class 0 OID 0)
-- Dependencies: 354
-- Name: timbrado_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.timbrado_id_seq', 2, true);


--
-- TOC entry 4238 (class 0 OID 0)
-- Dependencies: 339
-- Name: tipo_articulo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_articulo_id_seq', 3, true);


--
-- TOC entry 4239 (class 0 OID 0)
-- Dependencies: 341
-- Name: tipo_cheque_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_cheque_id_seq', 1, false);


--
-- TOC entry 4240 (class 0 OID 0)
-- Dependencies: 343
-- Name: tipo_documento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_documento_id_seq', 1, false);


--
-- TOC entry 4241 (class 0 OID 0)
-- Dependencies: 345
-- Name: tipo_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_item_id_seq', 1, false);


--
-- TOC entry 4242 (class 0 OID 0)
-- Dependencies: 347
-- Name: tipo_problemas_tip_proble_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_problemas_tip_proble_id_seq', 2, true);


--
-- TOC entry 4243 (class 0 OID 0)
-- Dependencies: 349
-- Name: tipo_tarjeta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_tarjeta_id_seq', 3, true);


--
-- TOC entry 4244 (class 0 OID 0)
-- Dependencies: 352
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_usuario_seq', 4, true);


--
-- TOC entry 4245 (class 0 OID 0)
-- Dependencies: 353
-- Name: usuariosroles_id_usuariorol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuariosroles_id_usuariorol_seq', 9, true);


--
-- TOC entry 3462 (class 2606 OID 738450)
-- Name: ajuste ajuste_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ajuste
    ADD CONSTRAINT ajuste_pkey PRIMARY KEY (id);


--
-- TOC entry 3464 (class 2606 OID 738452)
-- Name: apertura_cierre_caja apertura_cierre_caja_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apertura_cierre_caja
    ADD CONSTRAINT apertura_cierre_caja_pkey PRIMARY KEY (id);


--
-- TOC entry 3466 (class 2606 OID 738454)
-- Name: articulo articulo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articulo
    ADD CONSTRAINT articulo_pk PRIMARY KEY (id);


--
-- TOC entry 3468 (class 2606 OID 738456)
-- Name: articulo articulo_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articulo
    ADD CONSTRAINT articulo_un UNIQUE (descripcion);


--
-- TOC entry 3474 (class 2606 OID 738458)
-- Name: banco_cheque banco_cheque_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.banco_cheque
    ADD CONSTRAINT banco_cheque_pk PRIMARY KEY (id);


--
-- TOC entry 3476 (class 2606 OID 738460)
-- Name: banco_cheque banco_cheque_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.banco_cheque
    ADD CONSTRAINT banco_cheque_un UNIQUE (descripcion);


--
-- TOC entry 3470 (class 2606 OID 738462)
-- Name: banco banco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.banco
    ADD CONSTRAINT banco_pkey PRIMARY KEY (id);


--
-- TOC entry 3472 (class 2606 OID 738464)
-- Name: banco banco_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.banco
    ADD CONSTRAINT banco_un UNIQUE (descripcion);


--
-- TOC entry 3478 (class 2606 OID 738466)
-- Name: caja caja_caja_nro_caja_nro1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caja
    ADD CONSTRAINT caja_caja_nro_caja_nro1_key UNIQUE (numero) INCLUDE (numero);


--
-- TOC entry 3480 (class 2606 OID 738468)
-- Name: caja caja_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caja
    ADD CONSTRAINT caja_pkey PRIMARY KEY (id);


--
-- TOC entry 3482 (class 2606 OID 738470)
-- Name: cargo cargo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo
    ADD CONSTRAINT cargo_pk PRIMARY KEY (id);


--
-- TOC entry 3484 (class 2606 OID 738472)
-- Name: cargo cargo_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo
    ADD CONSTRAINT cargo_un UNIQUE (descripcion);


--
-- TOC entry 3486 (class 2606 OID 738474)
-- Name: ciudad ciudad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_pk PRIMARY KEY (id);


--
-- TOC entry 3488 (class 2606 OID 738476)
-- Name: ciudad ciudad_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_un UNIQUE (descripcion);


--
-- TOC entry 3490 (class 2606 OID 738478)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


--
-- TOC entry 3492 (class 2606 OID 738480)
-- Name: cobro cobro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cobro
    ADD CONSTRAINT cobro_pkey PRIMARY KEY (id);


--
-- TOC entry 3494 (class 2606 OID 738482)
-- Name: condicion_pago condicion_pago_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.condicion_pago
    ADD CONSTRAINT condicion_pago_pk PRIMARY KEY (id);


--
-- TOC entry 3496 (class 2606 OID 738484)
-- Name: condicion_pago condicion_pago_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.condicion_pago
    ADD CONSTRAINT condicion_pago_un UNIQUE (descripcion);


--
-- TOC entry 3498 (class 2606 OID 738486)
-- Name: cuenta_a_cobrar cuenta_a_cobrar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta_a_cobrar
    ADD CONSTRAINT cuenta_a_cobrar_pkey PRIMARY KEY (id);


--
-- TOC entry 3500 (class 2606 OID 738488)
-- Name: cuenta_a_pagar cuenta_a_pagar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta_a_pagar
    ADD CONSTRAINT cuenta_a_pagar_pkey PRIMARY KEY (id);


--
-- TOC entry 3502 (class 2606 OID 738490)
-- Name: deposito deposito_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deposito
    ADD CONSTRAINT deposito_pk PRIMARY KEY (id);


--
-- TOC entry 3504 (class 2606 OID 738492)
-- Name: deposito deposito_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deposito
    ADD CONSTRAINT deposito_un UNIQUE (descripcion);


--
-- TOC entry 3506 (class 2606 OID 738494)
-- Name: pedido_compra_detalle detalle_pedido_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra_detalle
    ADD CONSTRAINT detalle_pedido_compra_pkey PRIMARY KEY (id);


--
-- TOC entry 3510 (class 2606 OID 738496)
-- Name: diagnostico_detalle diagnostico_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnostico_detalle
    ADD CONSTRAINT diagnostico_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3508 (class 2606 OID 738498)
-- Name: diagnostico diagnostico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnostico
    ADD CONSTRAINT diagnostico_pkey PRIMARY KEY (id);


--
-- TOC entry 3516 (class 2606 OID 738500)
-- Name: empresa empresa_empre_ruc_empre_ruc1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_empre_ruc_empre_ruc1_key UNIQUE (ruc) INCLUDE (ruc);


--
-- TOC entry 3518 (class 2606 OID 738502)
-- Name: empresa empresa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (id);


--
-- TOC entry 3520 (class 2606 OID 738504)
-- Name: encargado encargado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encargado
    ADD CONSTRAINT encargado_pkey PRIMARY KEY (id);


--
-- TOC entry 3522 (class 2606 OID 738506)
-- Name: entidad_emisora entidad_emisora_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entidad_emisora
    ADD CONSTRAINT entidad_emisora_pk PRIMARY KEY (id);


--
-- TOC entry 3524 (class 2606 OID 738508)
-- Name: entidad_emisora entidad_emisora_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entidad_emisora
    ADD CONSTRAINT entidad_emisora_un UNIQUE (descripcion);


--
-- TOC entry 3526 (class 2606 OID 738510)
-- Name: equipo equipos_equi_serie_equi_serie1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipos_equi_serie_equi_serie1_key UNIQUE (serie) INCLUDE (serie);


--
-- TOC entry 3528 (class 2606 OID 738512)
-- Name: equipo equipos_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipos_pk PRIMARY KEY (id);


--
-- TOC entry 3530 (class 2606 OID 738514)
-- Name: estado estado_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pk PRIMARY KEY (id);


--
-- TOC entry 3532 (class 2606 OID 738516)
-- Name: estado estado_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_un UNIQUE (descripcion);


--
-- TOC entry 3538 (class 2606 OID 738518)
-- Name: factura_compra_detalle factura_compra_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_compra_detalle
    ADD CONSTRAINT factura_compra_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3536 (class 2606 OID 738520)
-- Name: factura_compra factura_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_compra
    ADD CONSTRAINT factura_compra_pkey PRIMARY KEY (id);


--
-- TOC entry 3540 (class 2606 OID 738522)
-- Name: factura_detalle factura_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_detalle
    ADD CONSTRAINT factura_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3534 (class 2606 OID 738524)
-- Name: factura factura_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT factura_pkey PRIMARY KEY (id);


--
-- TOC entry 3542 (class 2606 OID 738526)
-- Name: forma_cobro forma_cobro_form_descri_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.forma_cobro
    ADD CONSTRAINT forma_cobro_form_descri_key UNIQUE (descripcion);


--
-- TOC entry 3544 (class 2606 OID 738528)
-- Name: forma_cobro forma_cobro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.forma_cobro
    ADD CONSTRAINT forma_cobro_pkey PRIMARY KEY (id);


--
-- TOC entry 3546 (class 2606 OID 738530)
-- Name: formulario formularios_id_formulario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formulario
    ADD CONSTRAINT formularios_id_formulario_pk PRIMARY KEY (id);


--
-- TOC entry 3548 (class 2606 OID 738532)
-- Name: formulario formularios_url_formulario_url_formulario1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formulario
    ADD CONSTRAINT formularios_url_formulario_url_formulario1_key UNIQUE (url) INCLUDE (url);


--
-- TOC entry 3550 (class 2606 OID 738534)
-- Name: impuesto impuesto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.impuesto
    ADD CONSTRAINT impuesto_pk PRIMARY KEY (id);


--
-- TOC entry 3552 (class 2606 OID 738536)
-- Name: impuesto impuesto_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.impuesto
    ADD CONSTRAINT impuesto_un UNIQUE (descripcion);


--
-- TOC entry 3554 (class 2606 OID 738538)
-- Name: item item_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pk PRIMARY KEY (id);


--
-- TOC entry 3556 (class 2606 OID 738540)
-- Name: item items_item_descri_item_descri1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT items_item_descri_item_descri1_key UNIQUE (descripcion) INCLUDE (descripcion);


--
-- TOC entry 3560 (class 2606 OID 738542)
-- Name: libro_compra_detalle libro_compra_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_compra_detalle
    ADD CONSTRAINT libro_compra_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3558 (class 2606 OID 738544)
-- Name: libro_compra libro_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_compra
    ADD CONSTRAINT libro_compra_pkey PRIMARY KEY (id);


--
-- TOC entry 3564 (class 2606 OID 738546)
-- Name: libro_venta_detalle libro_venta_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_venta_detalle
    ADD CONSTRAINT libro_venta_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3562 (class 2606 OID 738548)
-- Name: libro_venta libro_venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_venta
    ADD CONSTRAINT libro_venta_pkey PRIMARY KEY (id);


--
-- TOC entry 3566 (class 2606 OID 738550)
-- Name: marca marca_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marca
    ADD CONSTRAINT marca_un UNIQUE (descripcion);


--
-- TOC entry 3569 (class 2606 OID 738552)
-- Name: marca marcas_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marca
    ADD CONSTRAINT marcas_pk PRIMARY KEY (id);


--
-- TOC entry 3571 (class 2606 OID 738554)
-- Name: motivo_ajuste motivo_ajuste_maju_descri_maju_descri1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motivo_ajuste
    ADD CONSTRAINT motivo_ajuste_maju_descri_maju_descri1_key UNIQUE (descripcion) INCLUDE (descripcion);


--
-- TOC entry 3573 (class 2606 OID 738556)
-- Name: motivo_ajuste motivo_ajuste_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motivo_ajuste
    ADD CONSTRAINT motivo_ajuste_pkey PRIMARY KEY (id);


--
-- TOC entry 3577 (class 2606 OID 738558)
-- Name: nota_credito_compra_detalle nota_credito_compra_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra_detalle
    ADD CONSTRAINT nota_credito_compra_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3575 (class 2606 OID 738560)
-- Name: nota_credito_compra nota_credito_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra
    ADD CONSTRAINT nota_credito_compra_pkey PRIMARY KEY (id);


--
-- TOC entry 3581 (class 2606 OID 738562)
-- Name: nota_debito_compra_detalle nota_debito_compra_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_debito_compra_detalle
    ADD CONSTRAINT nota_debito_compra_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3579 (class 2606 OID 738564)
-- Name: nota_debito_compra nota_debito_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_debito_compra
    ADD CONSTRAINT nota_debito_compra_pkey PRIMARY KEY (id);


--
-- TOC entry 3585 (class 2606 OID 738566)
-- Name: nota_remision_detalle nota_remision_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision_detalle
    ADD CONSTRAINT nota_remision_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3583 (class 2606 OID 738568)
-- Name: nota_remision nota_remision_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision
    ADD CONSTRAINT nota_remision_pkey PRIMARY KEY (id);


--
-- TOC entry 3589 (class 2606 OID 738570)
-- Name: orden_compra_detalle orden_compra_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra_detalle
    ADD CONSTRAINT orden_compra_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3587 (class 2606 OID 738572)
-- Name: orden_compra orden_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT orden_compra_pkey PRIMARY KEY (id);


--
-- TOC entry 3593 (class 2606 OID 738574)
-- Name: orden_servicio_detalle orden_servicio_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_servicio_detalle
    ADD CONSTRAINT orden_servicio_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3591 (class 2606 OID 738576)
-- Name: orden_servicio orden_servicio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_servicio
    ADD CONSTRAINT orden_servicio_pkey PRIMARY KEY (id);


--
-- TOC entry 3595 (class 2606 OID 738578)
-- Name: pago pago_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pago
    ADD CONSTRAINT pago_pkey PRIMARY KEY (id);


--
-- TOC entry 3597 (class 2606 OID 738580)
-- Name: pedido_compra pedido_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra
    ADD CONSTRAINT pedido_compra_pkey PRIMARY KEY (id);


--
-- TOC entry 3601 (class 2606 OID 738582)
-- Name: pedido_venta_detalle pedido_venta_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venta_detalle
    ADD CONSTRAINT pedido_venta_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3599 (class 2606 OID 738584)
-- Name: pedido_venta pedido_venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venta
    ADD CONSTRAINT pedido_venta_pkey PRIMARY KEY (id);


--
-- TOC entry 3603 (class 2606 OID 738586)
-- Name: permiso permisos_id_permiso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT permisos_id_permiso_pk PRIMARY KEY (id);


--
-- TOC entry 3512 (class 2606 OID 738588)
-- Name: persona persona_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pk PRIMARY KEY (id);


--
-- TOC entry 3514 (class 2606 OID 738590)
-- Name: persona persona_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_un UNIQUE (ci);


--
-- TOC entry 3607 (class 2606 OID 738592)
-- Name: presupuesto_compra_detalle presupuesto_compra_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra_detalle
    ADD CONSTRAINT presupuesto_compra_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3605 (class 2606 OID 738594)
-- Name: presupuesto_compra presupuesto_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra
    ADD CONSTRAINT presupuesto_compra_pkey PRIMARY KEY (id);


--
-- TOC entry 3611 (class 2606 OID 738596)
-- Name: presupuesto_servicio_detalle presupuesto_servicio_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_servicio_detalle
    ADD CONSTRAINT presupuesto_servicio_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3609 (class 2606 OID 738598)
-- Name: presupuesto_servicio presupuesto_servicio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_servicio
    ADD CONSTRAINT presupuesto_servicio_pkey PRIMARY KEY (id);


--
-- TOC entry 3613 (class 2606 OID 738600)
-- Name: promo_descuento promo_descuento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.promo_descuento
    ADD CONSTRAINT promo_descuento_pkey PRIMARY KEY (id);


--
-- TOC entry 3615 (class 2606 OID 738602)
-- Name: proveedor proveedores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT proveedores_pkey PRIMARY KEY (id);


--
-- TOC entry 3617 (class 2606 OID 738604)
-- Name: proveedor proveedores_prove_ruc_prove_ruc1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT proveedores_prove_ruc_prove_ruc1_key UNIQUE (ruc) INCLUDE (ruc);


--
-- TOC entry 3621 (class 2606 OID 738606)
-- Name: recepcion_detalle recepcion_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recepcion_detalle
    ADD CONSTRAINT recepcion_detalle_pkey PRIMARY KEY (id);


--
-- TOC entry 3619 (class 2606 OID 738608)
-- Name: recepcion recepcion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recepcion
    ADD CONSTRAINT recepcion_pkey PRIMARY KEY (id);


--
-- TOC entry 3623 (class 2606 OID 738610)
-- Name: rol roles_id_rol_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT roles_id_rol_pk PRIMARY KEY (id);


--
-- TOC entry 3625 (class 2606 OID 738612)
-- Name: rol roles_nombre_rol_unk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT roles_nombre_rol_unk UNIQUE (nombre);


--
-- TOC entry 3627 (class 2606 OID 738614)
-- Name: servicio servicio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT servicio_pkey PRIMARY KEY (id);


--
-- TOC entry 3629 (class 2606 OID 738616)
-- Name: servicios_por_diagnostico_detalle servicios_por_diagnostico_detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servicios_por_diagnostico_detalle
    ADD CONSTRAINT servicios_por_diagnostico_detalle_pkey PRIMARY KEY (id_diagnostico_detalle, id_servicio);


--
-- TOC entry 3631 (class 2606 OID 738618)
-- Name: sistema sistemas_id_sistema_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sistema
    ADD CONSTRAINT sistemas_id_sistema_pk PRIMARY KEY (id);


--
-- TOC entry 3633 (class 2606 OID 738620)
-- Name: sistema sistemas_nombre_sistema_unk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sistema
    ADD CONSTRAINT sistemas_nombre_sistema_unk UNIQUE (nombre);


--
-- TOC entry 3635 (class 2606 OID 738622)
-- Name: stock stock_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_pkey PRIMARY KEY (id);


--
-- TOC entry 3637 (class 2606 OID 738624)
-- Name: sub_menu submenus_id_submenu_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sub_menu
    ADD CONSTRAINT submenus_id_submenu_pk PRIMARY KEY (id);


--
-- TOC entry 3639 (class 2606 OID 738626)
-- Name: sub_menu submenus_nombre_submenu_unk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sub_menu
    ADD CONSTRAINT submenus_nombre_submenu_unk UNIQUE (nombre);


--
-- TOC entry 3641 (class 2606 OID 738628)
-- Name: sucursal sucursales_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sucursal
    ADD CONSTRAINT sucursales_pkey PRIMARY KEY (id);


--
-- TOC entry 3643 (class 2606 OID 738630)
-- Name: sucursal sucursales_suc_descri_suc_descri1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sucursal
    ADD CONSTRAINT sucursales_suc_descri_suc_descri1_key UNIQUE (descripcion) INCLUDE (descripcion);


--
-- TOC entry 3645 (class 2606 OID 738632)
-- Name: tarjeta tarjeta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjeta
    ADD CONSTRAINT tarjeta_pkey PRIMARY KEY (id);


--
-- TOC entry 3647 (class 2606 OID 738634)
-- Name: tarjeta tarjeta_tarjeta_descri_tarjeta_descri1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjeta
    ADD CONSTRAINT tarjeta_tarjeta_descri_tarjeta_descri1_key UNIQUE (descripcion) INCLUDE (descripcion);


--
-- TOC entry 3681 (class 2606 OID 739303)
-- Name: timbrado timbrado_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.timbrado
    ADD CONSTRAINT timbrado_pk PRIMARY KEY (id);


--
-- TOC entry 3649 (class 2606 OID 738640)
-- Name: tipo_articulo tipo_articulo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_articulo
    ADD CONSTRAINT tipo_articulo_pk PRIMARY KEY (id);


--
-- TOC entry 3651 (class 2606 OID 738642)
-- Name: tipo_articulo tipo_articulo_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_articulo
    ADD CONSTRAINT tipo_articulo_un UNIQUE (descripcion);


--
-- TOC entry 3653 (class 2606 OID 738644)
-- Name: tipo_cheque tipo_cheque_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cheque
    ADD CONSTRAINT tipo_cheque_pk PRIMARY KEY (id);


--
-- TOC entry 3655 (class 2606 OID 738646)
-- Name: tipo_cheque tipo_cheque_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cheque
    ADD CONSTRAINT tipo_cheque_un UNIQUE (descripcion);


--
-- TOC entry 3657 (class 2606 OID 738648)
-- Name: tipo_documento tipo_documento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_pk PRIMARY KEY (id);


--
-- TOC entry 3659 (class 2606 OID 738650)
-- Name: tipo_documento tipo_documento_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_un UNIQUE (descripcion);


--
-- TOC entry 3661 (class 2606 OID 738652)
-- Name: tipo_item tipo_item_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_item
    ADD CONSTRAINT tipo_item_pk PRIMARY KEY (id);


--
-- TOC entry 3663 (class 2606 OID 738654)
-- Name: tipo_item tipo_item_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_item
    ADD CONSTRAINT tipo_item_un UNIQUE (descripcion);


--
-- TOC entry 3665 (class 2606 OID 738656)
-- Name: tipo_problema tipo_problemas_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_problema
    ADD CONSTRAINT tipo_problemas_pk PRIMARY KEY (id);


--
-- TOC entry 3667 (class 2606 OID 738658)
-- Name: tipo_problema tipo_problemas_tipo_descri_tipo_descri1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_problema
    ADD CONSTRAINT tipo_problemas_tipo_descri_tipo_descri1_key UNIQUE (descripcion) INCLUDE (descripcion);


--
-- TOC entry 3669 (class 2606 OID 738660)
-- Name: tipo_tarjeta tipo_tarjeta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_tarjeta
    ADD CONSTRAINT tipo_tarjeta_pk PRIMARY KEY (id);


--
-- TOC entry 3671 (class 2606 OID 738662)
-- Name: tipo_tarjeta tipo_tarjeta_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_tarjeta
    ADD CONSTRAINT tipo_tarjeta_un UNIQUE (descripcion);


--
-- TOC entry 3673 (class 2606 OID 738664)
-- Name: usuario usuarios_id_usuario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuarios_id_usuario_pk PRIMARY KEY (id);


--
-- TOC entry 3675 (class 2606 OID 738666)
-- Name: usuario usuarios_usuario_usuario_usuario_usuario1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuarios_usuario_usuario_usuario_usuario1_key UNIQUE (usuario) INCLUDE (usuario);


--
-- TOC entry 3677 (class 2606 OID 738668)
-- Name: usuario_rol usuariosroles_id_usuario_id_rol_id_usuario1_id_rol1_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT usuariosroles_id_usuario_id_rol_id_usuario1_id_rol1_key UNIQUE (id_usuario, id_rol) INCLUDE (id_usuario, id_rol);


--
-- TOC entry 3679 (class 2606 OID 738670)
-- Name: usuario_rol usuariosroles_id_usuariorol_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT usuariosroles_id_usuariorol_pk PRIMARY KEY (id);


--
-- TOC entry 3567 (class 1259 OID 738671)
-- Name: marcas_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX marcas_index ON public.marca USING btree (lower((descripcion)::text));


--
-- TOC entry 3682 (class 2606 OID 738672)
-- Name: ajuste ajuste_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ajuste
    ADD CONSTRAINT ajuste_fk FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3684 (class 2606 OID 738677)
-- Name: apertura_cierre_caja apertura_cierre_caja_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apertura_cierre_caja
    ADD CONSTRAINT apertura_cierre_caja_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3686 (class 2606 OID 738682)
-- Name: articulo articulo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articulo
    ADD CONSTRAINT articulo_fk FOREIGN KEY (id_impuesto) REFERENCES public.impuesto(id);


--
-- TOC entry 3687 (class 2606 OID 738687)
-- Name: articulo articulo_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articulo
    ADD CONSTRAINT articulo_fk_1 FOREIGN KEY (id_marca) REFERENCES public.marca(id);


--
-- TOC entry 3688 (class 2606 OID 738692)
-- Name: articulo articulo_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articulo
    ADD CONSTRAINT articulo_fk_2 FOREIGN KEY (id_tipo_articulo) REFERENCES public.tipo_articulo(id);


--
-- TOC entry 3689 (class 2606 OID 738697)
-- Name: caja caja_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caja
    ADD CONSTRAINT caja_fk FOREIGN KEY (id_sucursal) REFERENCES public.sucursal(id);


--
-- TOC entry 3694 (class 2606 OID 738702)
-- Name: cuenta_a_pagar cuenta_a_pagar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta_a_pagar
    ADD CONSTRAINT cuenta_a_pagar_fk FOREIGN KEY (id_pago) REFERENCES public.pago(id);


--
-- TOC entry 3696 (class 2606 OID 738707)
-- Name: deposito deposito_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deposito
    ADD CONSTRAINT deposito_fk FOREIGN KEY (id_sucursal) REFERENCES public.sucursal(id);


--
-- TOC entry 3702 (class 2606 OID 738712)
-- Name: diagnostico_detalle diagnostico_detalle_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnostico_detalle
    ADD CONSTRAINT diagnostico_detalle_fk FOREIGN KEY (id_servicio) REFERENCES public.servicio(id);


--
-- TOC entry 3705 (class 2606 OID 738717)
-- Name: persona empleado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT empleado_fk FOREIGN KEY (id_ciudad) REFERENCES public.ciudad(id);


--
-- TOC entry 3707 (class 2606 OID 738722)
-- Name: equipo equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_fk FOREIGN KEY (id_marca) REFERENCES public.marca(id);


--
-- TOC entry 3708 (class 2606 OID 738727)
-- Name: equipo equipo_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_fk_2 FOREIGN KEY (id_cliente) REFERENCES public.cliente(id);


--
-- TOC entry 3709 (class 2606 OID 739283)
-- Name: factura factura_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT factura_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3710 (class 2606 OID 739304)
-- Name: factura factura_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT factura_fk_2 FOREIGN KEY (id_timbrado) REFERENCES public.timbrado(id);


--
-- TOC entry 3683 (class 2606 OID 738732)
-- Name: ajuste fk_ajuste_id_stock; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ajuste
    ADD CONSTRAINT fk_ajuste_id_stock FOREIGN KEY (id_stock) REFERENCES public.stock(id);


--
-- TOC entry 3685 (class 2606 OID 738737)
-- Name: apertura_cierre_caja fk_apertura_cierre_caja_id_caja; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apertura_cierre_caja
    ADD CONSTRAINT fk_apertura_cierre_caja_id_caja FOREIGN KEY (id_caja) REFERENCES public.caja(id);


--
-- TOC entry 3690 (class 2606 OID 738742)
-- Name: cliente fk_cliente_id_ciudad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_cliente_id_ciudad FOREIGN KEY (id_ciudad) REFERENCES public.ciudad(id);


--
-- TOC entry 3691 (class 2606 OID 738747)
-- Name: cuenta_a_cobrar fk_cuenta_a_cobrar_id_cobro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta_a_cobrar
    ADD CONSTRAINT fk_cuenta_a_cobrar_id_cobro FOREIGN KEY (id_cobro) REFERENCES public.cobro(id);


--
-- TOC entry 3692 (class 2606 OID 738752)
-- Name: cuenta_a_cobrar fk_cuenta_a_cobrar_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta_a_cobrar
    ADD CONSTRAINT fk_cuenta_a_cobrar_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3693 (class 2606 OID 738757)
-- Name: cuenta_a_cobrar fk_cuenta_a_cobrar_id_factura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta_a_cobrar
    ADD CONSTRAINT fk_cuenta_a_cobrar_id_factura FOREIGN KEY (id_factura) REFERENCES public.factura(id);


--
-- TOC entry 3695 (class 2606 OID 738762)
-- Name: cuenta_a_pagar fk_cuenta_a_pagar_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta_a_pagar
    ADD CONSTRAINT fk_cuenta_a_pagar_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3697 (class 2606 OID 738767)
-- Name: pedido_compra_detalle fk_detalle_pedido_compra_id_articulo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra_detalle
    ADD CONSTRAINT fk_detalle_pedido_compra_id_articulo FOREIGN KEY (id_articulo) REFERENCES public.articulo(id);


--
-- TOC entry 3698 (class 2606 OID 738772)
-- Name: pedido_compra_detalle fk_detalle_pedido_compra_id_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra_detalle
    ADD CONSTRAINT fk_detalle_pedido_compra_id_detalle FOREIGN KEY (id_pedido_compra) REFERENCES public.pedido_compra(id);


--
-- TOC entry 3703 (class 2606 OID 738777)
-- Name: diagnostico_detalle fk_diagnostico_detalle_id_diagnostico; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnostico_detalle
    ADD CONSTRAINT fk_diagnostico_detalle_id_diagnostico FOREIGN KEY (id_diagnostico) REFERENCES public.diagnostico(id);


--
-- TOC entry 3704 (class 2606 OID 738782)
-- Name: diagnostico_detalle fk_diagnostico_detalle_id_recepcion_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnostico_detalle
    ADD CONSTRAINT fk_diagnostico_detalle_id_recepcion_detalle FOREIGN KEY (id_recepcion_detalle) REFERENCES public.recepcion_detalle(id);


--
-- TOC entry 3699 (class 2606 OID 738787)
-- Name: diagnostico fk_diagnostico_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnostico
    ADD CONSTRAINT fk_diagnostico_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3700 (class 2606 OID 738792)
-- Name: diagnostico fk_diagnostico_id_recepcion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnostico
    ADD CONSTRAINT fk_diagnostico_id_recepcion FOREIGN KEY (id_recepcion) REFERENCES public.recepcion(id);


--
-- TOC entry 3701 (class 2606 OID 738797)
-- Name: diagnostico fk_diagnostico_id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnostico
    ADD CONSTRAINT fk_diagnostico_id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3720 (class 2606 OID 738802)
-- Name: factura_compra_detalle fk_factura_compra_detalle_id_factura_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_compra_detalle
    ADD CONSTRAINT fk_factura_compra_detalle_id_factura_compra FOREIGN KEY (id_factura_compra) REFERENCES public.factura_compra(id);


--
-- TOC entry 3721 (class 2606 OID 738807)
-- Name: factura_compra_detalle fk_factura_compra_detalle_id_orden_compra_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_compra_detalle
    ADD CONSTRAINT fk_factura_compra_detalle_id_orden_compra_detalle FOREIGN KEY (id_orden_compra_detalle) REFERENCES public.orden_compra_detalle(id);


--
-- TOC entry 3716 (class 2606 OID 738812)
-- Name: factura_compra fk_factura_compra_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_compra
    ADD CONSTRAINT fk_factura_compra_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3717 (class 2606 OID 738817)
-- Name: factura_compra fk_factura_compra_id_libro_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_compra
    ADD CONSTRAINT fk_factura_compra_id_libro_compra FOREIGN KEY (id_libro_compra) REFERENCES public.libro_compra(id);


--
-- TOC entry 3718 (class 2606 OID 738822)
-- Name: factura_compra fk_factura_compra_id_orden_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_compra
    ADD CONSTRAINT fk_factura_compra_id_orden_compra FOREIGN KEY (id_orden_compra) REFERENCES public.orden_compra(id);


--
-- TOC entry 3719 (class 2606 OID 738827)
-- Name: factura_compra fk_factura_compra_id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_compra
    ADD CONSTRAINT fk_factura_compra_id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3722 (class 2606 OID 738832)
-- Name: factura_detalle fk_factura_detalle_id_factura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_detalle
    ADD CONSTRAINT fk_factura_detalle_id_factura FOREIGN KEY (id_factura) REFERENCES public.factura(id);


--
-- TOC entry 3723 (class 2606 OID 738837)
-- Name: factura_detalle fk_factura_detalle_id_oreden_servicio_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_detalle
    ADD CONSTRAINT fk_factura_detalle_id_oreden_servicio_detalle FOREIGN KEY (id_oreden_servicio_detalle) REFERENCES public.orden_servicio_detalle(id);


--
-- TOC entry 3724 (class 2606 OID 738842)
-- Name: factura_detalle fk_factura_detalle_id_pedido_venta_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura_detalle
    ADD CONSTRAINT fk_factura_detalle_id_pedido_venta_detalle FOREIGN KEY (id_pedido_venta_detalle) REFERENCES public.pedido_venta_detalle(id);


--
-- TOC entry 3711 (class 2606 OID 738847)
-- Name: factura fk_factura_id_caja; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fk_factura_id_caja FOREIGN KEY (id_caja) REFERENCES public.caja(id);


--
-- TOC entry 3712 (class 2606 OID 738852)
-- Name: factura fk_factura_id_condicion_pago; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fk_factura_id_condicion_pago FOREIGN KEY (id_condicion_pago) REFERENCES public.condicion_pago(id);


--
-- TOC entry 3713 (class 2606 OID 738857)
-- Name: factura fk_factura_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fk_factura_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3714 (class 2606 OID 738862)
-- Name: factura fk_factura_id_libro_venta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fk_factura_id_libro_venta FOREIGN KEY (id_libro_venta) REFERENCES public.libro_venta(id);


--
-- TOC entry 3715 (class 2606 OID 738867)
-- Name: factura fk_factura_id_pedido_venta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fk_factura_id_pedido_venta FOREIGN KEY (id_pedido_venta) REFERENCES public.pedido_venta(id);


--
-- TOC entry 3727 (class 2606 OID 738877)
-- Name: libro_compra_detalle fk_libro_compra_detalle_id_factura_compra_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_compra_detalle
    ADD CONSTRAINT fk_libro_compra_detalle_id_factura_compra_detalle FOREIGN KEY (id_factura_compra_detalle) REFERENCES public.factura_compra_detalle(id);


--
-- TOC entry 3728 (class 2606 OID 738882)
-- Name: libro_compra_detalle fk_libro_compra_detalle_id_impuesto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_compra_detalle
    ADD CONSTRAINT fk_libro_compra_detalle_id_impuesto FOREIGN KEY (id_impuesto) REFERENCES public.impuesto(id);


--
-- TOC entry 3729 (class 2606 OID 738887)
-- Name: libro_compra_detalle fk_libro_compra_detalle_id_libro_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_compra_detalle
    ADD CONSTRAINT fk_libro_compra_detalle_id_libro_compra FOREIGN KEY (id_libro_compra) REFERENCES public.libro_compra(id);


--
-- TOC entry 3730 (class 2606 OID 738892)
-- Name: libro_venta_detalle fk_libro_venta_detalle_id_factura_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_venta_detalle
    ADD CONSTRAINT fk_libro_venta_detalle_id_factura_detalle FOREIGN KEY (id_factura_detalle) REFERENCES public.factura_detalle(id);


--
-- TOC entry 3731 (class 2606 OID 738897)
-- Name: libro_venta_detalle fk_libro_venta_detalle_id_impuesto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_venta_detalle
    ADD CONSTRAINT fk_libro_venta_detalle_id_impuesto FOREIGN KEY (id_impuesto) REFERENCES public.impuesto(id);


--
-- TOC entry 3732 (class 2606 OID 738902)
-- Name: libro_venta_detalle fk_libro_venta_detalle_id_libro_venta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_venta_detalle
    ADD CONSTRAINT fk_libro_venta_detalle_id_libro_venta FOREIGN KEY (id_libro_venta) REFERENCES public.libro_venta(id);


--
-- TOC entry 3738 (class 2606 OID 738907)
-- Name: nota_credito_compra_detalle fk_nota_credito_compra_detalle_id_articulo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra_detalle
    ADD CONSTRAINT fk_nota_credito_compra_detalle_id_articulo FOREIGN KEY (id_articulo) REFERENCES public.articulo(id);


--
-- TOC entry 3739 (class 2606 OID 738912)
-- Name: nota_credito_compra_detalle fk_nota_credito_compra_detalle_id_nota_credito_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra_detalle
    ADD CONSTRAINT fk_nota_credito_compra_detalle_id_nota_credito_compra FOREIGN KEY (id_nota_credito_compra) REFERENCES public.nota_credito_compra(id);


--
-- TOC entry 3735 (class 2606 OID 738917)
-- Name: nota_credito_compra fk_nota_credito_compra_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra
    ADD CONSTRAINT fk_nota_credito_compra_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3736 (class 2606 OID 738922)
-- Name: nota_credito_compra fk_nota_credito_compra_id_factura_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra
    ADD CONSTRAINT fk_nota_credito_compra_id_factura_compra FOREIGN KEY (id_factura_compra) REFERENCES public.factura_compra(id);


--
-- TOC entry 3737 (class 2606 OID 738927)
-- Name: nota_credito_compra fk_nota_credito_compra_id_proveedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra
    ADD CONSTRAINT fk_nota_credito_compra_id_proveedor FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id);


--
-- TOC entry 3743 (class 2606 OID 738932)
-- Name: nota_debito_compra_detalle fk_nota_debito_compra_detalle_id_factura_compra_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_debito_compra_detalle
    ADD CONSTRAINT fk_nota_debito_compra_detalle_id_factura_compra_detalle FOREIGN KEY (id_factura_compra_detalle) REFERENCES public.factura_compra_detalle(id);


--
-- TOC entry 3744 (class 2606 OID 738937)
-- Name: nota_debito_compra_detalle fk_nota_debito_compra_detalle_id_nota_debito; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_debito_compra_detalle
    ADD CONSTRAINT fk_nota_debito_compra_detalle_id_nota_debito FOREIGN KEY (id_nota_debito) REFERENCES public.nota_debito_compra(id);


--
-- TOC entry 3740 (class 2606 OID 738942)
-- Name: nota_debito_compra fk_nota_debito_compra_id_cuenta_a_pagar; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_debito_compra
    ADD CONSTRAINT fk_nota_debito_compra_id_cuenta_a_pagar FOREIGN KEY (id_cuenta_a_pagar) REFERENCES public.cuenta_a_pagar(id);


--
-- TOC entry 3741 (class 2606 OID 738947)
-- Name: nota_debito_compra fk_nota_debito_compra_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_debito_compra
    ADD CONSTRAINT fk_nota_debito_compra_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3742 (class 2606 OID 738952)
-- Name: nota_debito_compra fk_nota_debito_compra_id_factura_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_debito_compra
    ADD CONSTRAINT fk_nota_debito_compra_id_factura_compra FOREIGN KEY (id_factura_compra) REFERENCES public.factura_compra(id);


--
-- TOC entry 3751 (class 2606 OID 738957)
-- Name: nota_remision_detalle fk_nota_remision_detalle_id_articulo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision_detalle
    ADD CONSTRAINT fk_nota_remision_detalle_id_articulo FOREIGN KEY (id_articulo) REFERENCES public.articulo(id);


--
-- TOC entry 3752 (class 2606 OID 738962)
-- Name: nota_remision_detalle fk_nota_remision_detalle_id_nota_remision; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision_detalle
    ADD CONSTRAINT fk_nota_remision_detalle_id_nota_remision FOREIGN KEY (id_nota_remision) REFERENCES public.nota_remision(id);


--
-- TOC entry 3753 (class 2606 OID 738967)
-- Name: nota_remision_detalle fk_nota_remision_detalle_id_pedido_compra_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision_detalle
    ADD CONSTRAINT fk_nota_remision_detalle_id_pedido_compra_detalle FOREIGN KEY (id_pedido_compra_detalle) REFERENCES public.pedido_compra_detalle(id);


--
-- TOC entry 3746 (class 2606 OID 738972)
-- Name: nota_remision fk_nota_remision_id_destino; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision
    ADD CONSTRAINT fk_nota_remision_id_destino FOREIGN KEY (id_destino) REFERENCES public.deposito(id);


--
-- TOC entry 3747 (class 2606 OID 738977)
-- Name: nota_remision fk_nota_remision_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision
    ADD CONSTRAINT fk_nota_remision_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3748 (class 2606 OID 738982)
-- Name: nota_remision fk_nota_remision_id_factura_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision
    ADD CONSTRAINT fk_nota_remision_id_factura_compra FOREIGN KEY (id_factura_compra) REFERENCES public.factura_compra(id);


--
-- TOC entry 3749 (class 2606 OID 738987)
-- Name: nota_remision fk_nota_remision_id_origen; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision
    ADD CONSTRAINT fk_nota_remision_id_origen FOREIGN KEY (id_origen) REFERENCES public.deposito(id);


--
-- TOC entry 3750 (class 2606 OID 738992)
-- Name: nota_remision fk_nota_remision_id_pedido_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision
    ADD CONSTRAINT fk_nota_remision_id_pedido_compra FOREIGN KEY (id_pedido_compra) REFERENCES public.pedido_compra(id);


--
-- TOC entry 3758 (class 2606 OID 738997)
-- Name: orden_compra_detalle fk_orden_compra_detalle_id_orden_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra_detalle
    ADD CONSTRAINT fk_orden_compra_detalle_id_orden_compra FOREIGN KEY (id_orden_compra) REFERENCES public.orden_compra(id);


--
-- TOC entry 3759 (class 2606 OID 739002)
-- Name: orden_compra_detalle fk_orden_compra_detalle_id_presupueto_compra_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra_detalle
    ADD CONSTRAINT fk_orden_compra_detalle_id_presupueto_compra_detalle FOREIGN KEY (id_presupueto_compra_detalle) REFERENCES public.presupuesto_compra_detalle(id);


--
-- TOC entry 3754 (class 2606 OID 739007)
-- Name: orden_compra fk_orden_compra_id_condicion_pago; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT fk_orden_compra_id_condicion_pago FOREIGN KEY (id_condicion_pago) REFERENCES public.condicion_pago(id);


--
-- TOC entry 3755 (class 2606 OID 739012)
-- Name: orden_compra fk_orden_compra_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT fk_orden_compra_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3756 (class 2606 OID 739017)
-- Name: orden_compra fk_orden_compra_id_proveedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT fk_orden_compra_id_proveedor FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id);


--
-- TOC entry 3757 (class 2606 OID 739022)
-- Name: orden_compra fk_orden_compra_id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT fk_orden_compra_id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3764 (class 2606 OID 739027)
-- Name: orden_servicio_detalle fk_orden_servicio_detalle_id_orden_servicio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_servicio_detalle
    ADD CONSTRAINT fk_orden_servicio_detalle_id_orden_servicio FOREIGN KEY (id_orden_servicio) REFERENCES public.orden_servicio(id);


--
-- TOC entry 3765 (class 2606 OID 739032)
-- Name: orden_servicio_detalle fk_orden_servicio_detalle_id_presupueto_servicio_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_servicio_detalle
    ADD CONSTRAINT fk_orden_servicio_detalle_id_presupueto_servicio_detalle FOREIGN KEY (id_presupueto_servicio_detalle) REFERENCES public.presupuesto_servicio_detalle(id);


--
-- TOC entry 3761 (class 2606 OID 739037)
-- Name: orden_servicio fk_orden_servicio_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_servicio
    ADD CONSTRAINT fk_orden_servicio_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3762 (class 2606 OID 739042)
-- Name: orden_servicio fk_orden_servicio_id_presupuesto_servicio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_servicio
    ADD CONSTRAINT fk_orden_servicio_id_presupuesto_servicio FOREIGN KEY (id_presupuesto_servicio) REFERENCES public.presupuesto_servicio(id);


--
-- TOC entry 3763 (class 2606 OID 739047)
-- Name: orden_servicio fk_orden_servicio_id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_servicio
    ADD CONSTRAINT fk_orden_servicio_id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3766 (class 2606 OID 739052)
-- Name: pedido_compra fk_pedido_compra_id_deposito; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra
    ADD CONSTRAINT fk_pedido_compra_id_deposito FOREIGN KEY (id_deposito) REFERENCES public.deposito(id);


--
-- TOC entry 3767 (class 2606 OID 739057)
-- Name: pedido_compra fk_pedido_compra_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra
    ADD CONSTRAINT fk_pedido_compra_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3768 (class 2606 OID 739062)
-- Name: pedido_compra fk_pedido_compra_id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra
    ADD CONSTRAINT fk_pedido_compra_id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3773 (class 2606 OID 739067)
-- Name: pedido_venta_detalle fk_pedido_venta_detalle_id_articulo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venta_detalle
    ADD CONSTRAINT fk_pedido_venta_detalle_id_articulo FOREIGN KEY (id_articulo) REFERENCES public.articulo(id);


--
-- TOC entry 3774 (class 2606 OID 739072)
-- Name: pedido_venta_detalle fk_pedido_venta_detalle_id_pedido_venta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venta_detalle
    ADD CONSTRAINT fk_pedido_venta_detalle_id_pedido_venta FOREIGN KEY (id_pedido_venta) REFERENCES public.pedido_venta(id);


--
-- TOC entry 3770 (class 2606 OID 739077)
-- Name: pedido_venta fk_pedido_venta_id_deposito; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venta
    ADD CONSTRAINT fk_pedido_venta_id_deposito FOREIGN KEY (id_deposito) REFERENCES public.deposito(id);


--
-- TOC entry 3771 (class 2606 OID 739082)
-- Name: pedido_venta fk_pedido_venta_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venta
    ADD CONSTRAINT fk_pedido_venta_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3772 (class 2606 OID 739087)
-- Name: pedido_venta fk_pedido_venta_id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venta
    ADD CONSTRAINT fk_pedido_venta_id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3782 (class 2606 OID 739092)
-- Name: presupuesto_compra_detalle fk_presupuesto_compra_detalle_id_pedido_compra_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra_detalle
    ADD CONSTRAINT fk_presupuesto_compra_detalle_id_pedido_compra_detalle FOREIGN KEY (id_pedido_compra_detalle) REFERENCES public.pedido_compra_detalle(id);


--
-- TOC entry 3783 (class 2606 OID 739097)
-- Name: presupuesto_compra_detalle fk_presupuesto_compra_detalle_id_presuesto_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra_detalle
    ADD CONSTRAINT fk_presupuesto_compra_detalle_id_presuesto_compra FOREIGN KEY (id_presuesto_compra) REFERENCES public.presupuesto_compra(id);


--
-- TOC entry 3779 (class 2606 OID 739102)
-- Name: presupuesto_compra fk_presupuesto_compra_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra
    ADD CONSTRAINT fk_presupuesto_compra_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3780 (class 2606 OID 739107)
-- Name: presupuesto_compra fk_presupuesto_compra_id_pedido_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra
    ADD CONSTRAINT fk_presupuesto_compra_id_pedido_compra FOREIGN KEY (id_pedido_compra) REFERENCES public.pedido_compra(id);


--
-- TOC entry 3781 (class 2606 OID 739112)
-- Name: presupuesto_compra fk_presupuesto_compra_id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra
    ADD CONSTRAINT fk_presupuesto_compra_id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3788 (class 2606 OID 739117)
-- Name: presupuesto_servicio_detalle fk_presupuesto_servicio_detalle_id_diagnostico_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_servicio_detalle
    ADD CONSTRAINT fk_presupuesto_servicio_detalle_id_diagnostico_detalle FOREIGN KEY (id_diagnostico_detalle) REFERENCES public.diagnostico_detalle(id);


--
-- TOC entry 3789 (class 2606 OID 739122)
-- Name: presupuesto_servicio_detalle fk_presupuesto_servicio_detalle_id_presuesto_servicio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_servicio_detalle
    ADD CONSTRAINT fk_presupuesto_servicio_detalle_id_presuesto_servicio FOREIGN KEY (id_presuesto_servicio) REFERENCES public.presupuesto_servicio(id);


--
-- TOC entry 3784 (class 2606 OID 739127)
-- Name: presupuesto_servicio fk_presupuesto_servicio_id_diagnostico; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_servicio
    ADD CONSTRAINT fk_presupuesto_servicio_id_diagnostico FOREIGN KEY (id_diagnostico) REFERENCES public.diagnostico(id);


--
-- TOC entry 3785 (class 2606 OID 739132)
-- Name: presupuesto_servicio fk_presupuesto_servicio_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_servicio
    ADD CONSTRAINT fk_presupuesto_servicio_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3786 (class 2606 OID 739137)
-- Name: presupuesto_servicio fk_presupuesto_servicio_id_promo_descuento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_servicio
    ADD CONSTRAINT fk_presupuesto_servicio_id_promo_descuento FOREIGN KEY (id_promo_descuento) REFERENCES public.promo_descuento(id);


--
-- TOC entry 3787 (class 2606 OID 739142)
-- Name: presupuesto_servicio fk_presupuesto_servicio_id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_servicio
    ADD CONSTRAINT fk_presupuesto_servicio_id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3795 (class 2606 OID 739147)
-- Name: recepcion_detalle fk_recepcion_detalle_id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recepcion_detalle
    ADD CONSTRAINT fk_recepcion_detalle_id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipo(id);


--
-- TOC entry 3796 (class 2606 OID 739152)
-- Name: recepcion_detalle fk_recepcion_detalle_id_recepcion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recepcion_detalle
    ADD CONSTRAINT fk_recepcion_detalle_id_recepcion FOREIGN KEY (id_recepcion) REFERENCES public.recepcion(id);


--
-- TOC entry 3793 (class 2606 OID 739158)
-- Name: recepcion fk_recepcion_id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recepcion
    ADD CONSTRAINT fk_recepcion_id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- TOC entry 3794 (class 2606 OID 739163)
-- Name: recepcion fk_recepcion_id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recepcion
    ADD CONSTRAINT fk_recepcion_id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3799 (class 2606 OID 739168)
-- Name: servicios_por_diagnostico_detalle fk_servicios_por_diagnostico_detalle_id_diagnostico_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servicios_por_diagnostico_detalle
    ADD CONSTRAINT fk_servicios_por_diagnostico_detalle_id_diagnostico_detalle FOREIGN KEY (id_diagnostico_detalle) REFERENCES public.diagnostico_detalle(id);


--
-- TOC entry 3800 (class 2606 OID 739173)
-- Name: servicios_por_diagnostico_detalle fk_servicios_por_diagnostico_detalle_id_servicio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servicios_por_diagnostico_detalle
    ADD CONSTRAINT fk_servicios_por_diagnostico_detalle_id_servicio FOREIGN KEY (id_servicio) REFERENCES public.servicio(id);


--
-- TOC entry 3801 (class 2606 OID 739178)
-- Name: stock fk_stock_id_articulo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT fk_stock_id_articulo FOREIGN KEY (id_articulo) REFERENCES public.articulo(id);


--
-- TOC entry 3802 (class 2606 OID 739183)
-- Name: stock fk_stock_id_deposito; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT fk_stock_id_deposito FOREIGN KEY (id_deposito) REFERENCES public.deposito(id);


--
-- TOC entry 3725 (class 2606 OID 739188)
-- Name: formulario formulario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formulario
    ADD CONSTRAINT formulario_fk FOREIGN KEY (id_sistema) REFERENCES public.sistema(id);


--
-- TOC entry 3726 (class 2606 OID 739193)
-- Name: formulario formulario_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formulario
    ADD CONSTRAINT formulario_fk_1 FOREIGN KEY (id_sub_menu) REFERENCES public.sub_menu(id);


--
-- TOC entry 3733 (class 2606 OID 739198)
-- Name: nota_credito_compra nota_credito_compra_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra
    ADD CONSTRAINT nota_credito_compra_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3734 (class 2606 OID 739203)
-- Name: nota_credito_compra nota_credito_compra_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_credito_compra
    ADD CONSTRAINT nota_credito_compra_fk_2 FOREIGN KEY (id_orden_compra_cancelacion) REFERENCES public.orden_compra(id);


--
-- TOC entry 3745 (class 2606 OID 739208)
-- Name: nota_remision nota_remision_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_remision
    ADD CONSTRAINT nota_remision_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- TOC entry 3760 (class 2606 OID 739309)
-- Name: orden_servicio orden_servicio_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_servicio
    ADD CONSTRAINT orden_servicio_fk FOREIGN KEY (id_factura) REFERENCES public.factura(id);


--
-- TOC entry 3769 (class 2606 OID 739213)
-- Name: pedido_venta pedido_venta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venta
    ADD CONSTRAINT pedido_venta_fk FOREIGN KEY (id_cliente) REFERENCES public.cliente(id);


--
-- TOC entry 3775 (class 2606 OID 739218)
-- Name: permiso permiso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT permiso_fk FOREIGN KEY (id_formulario) REFERENCES public.formulario(id);


--
-- TOC entry 3776 (class 2606 OID 739223)
-- Name: permiso permiso_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT permiso_fk_1 FOREIGN KEY (id_rol) REFERENCES public.rol(id);


--
-- TOC entry 3777 (class 2606 OID 739228)
-- Name: presupuesto_compra presupuesto_compra_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra
    ADD CONSTRAINT presupuesto_compra_fk FOREIGN KEY (id_proveedor) REFERENCES public.proveedor(id);


--
-- TOC entry 3778 (class 2606 OID 739233)
-- Name: presupuesto_compra presupuesto_compra_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.presupuesto_compra
    ADD CONSTRAINT presupuesto_compra_fk_2 FOREIGN KEY (id_orden_compra) REFERENCES public.orden_compra(id);


--
-- TOC entry 3790 (class 2606 OID 739238)
-- Name: proveedor proveedor_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT proveedor_fk FOREIGN KEY (id_ciudad) REFERENCES public.ciudad(id);


--
-- TOC entry 3791 (class 2606 OID 739243)
-- Name: recepcion recepcion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recepcion
    ADD CONSTRAINT recepcion_fk FOREIGN KEY (id_sucursal) REFERENCES public.sucursal(id);


--
-- TOC entry 3792 (class 2606 OID 739288)
-- Name: recepcion recepcion_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recepcion
    ADD CONSTRAINT recepcion_fk_2 FOREIGN KEY (id_cliente) REFERENCES public.cliente(id);


--
-- TOC entry 3797 (class 2606 OID 739248)
-- Name: servicio servicio_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT servicio_fk FOREIGN KEY (id_impuesto) REFERENCES public.impuesto(id);


--
-- TOC entry 3798 (class 2606 OID 739253)
-- Name: servicio servicio_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT servicio_fk_2 FOREIGN KEY (id_articulo) REFERENCES public.articulo(id);


--
-- TOC entry 3803 (class 2606 OID 739258)
-- Name: sucursal sucursal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sucursal
    ADD CONSTRAINT sucursal_fk FOREIGN KEY (id_ciudad) REFERENCES public.ciudad(id);


--
-- TOC entry 3706 (class 2606 OID 739263)
-- Name: encargado sucursales_encargado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encargado
    ADD CONSTRAINT sucursales_encargado_fk FOREIGN KEY (id_sucursal) REFERENCES public.sucursal(id);


--
-- TOC entry 3804 (class 2606 OID 739268)
-- Name: usuario usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_fk FOREIGN KEY (id_sucursal) REFERENCES public.sucursal(id);


--
-- TOC entry 3805 (class 2606 OID 739273)
-- Name: usuario_rol usuariosroles_id_rol_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT usuariosroles_id_rol_fk FOREIGN KEY (id_rol) REFERENCES public.rol(id);


--
-- TOC entry 3806 (class 2606 OID 739278)
-- Name: usuario_rol usuariosroles_id_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT usuariosroles_id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


-- Completed on 2022-11-11 16:05:31 -03

--
-- PostgreSQL database dump complete
--


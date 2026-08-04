CREATE TABLE employees (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    hire_date DATE NOT NULL,
    employee_type VARCHAR(20) NOT NULL
);

CREATE TABLE full_time_employees (
    id BIGINT PRIMARY KEY REFERENCES employees(id),
    annual_salary NUMERIC(10,2) NOT NULL,
    overtime_eligible BOOLEAN NOT NULL DEFAULT false
);

CREATE TABLE part_time_employees (
    id BIGINT PRIMARY KEY REFERENCES employees(id),
    hourly_rate NUMERIC(6,2) NOT NULL,
    max_weekly_hours INT NOT NULL DEFAULT 29
);

CREATE TABLE contract_employees (
    id BIGINT PRIMARY KEY REFERENCES employees(id),
    per_shift_rate NUMERIC(6,2) NOT NULL,
    contract_end_date DATE NOT NULL
);

CREATE TABLE shifts (
    id BIGSERIAL PRIMARY KEY,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    location VARCHAR(100) NOT NULL,
    employee_id BIGINT REFERENCES employees(id)
);

CREATE TABLE pay_records (
    id BIGSERIAL PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES employees(id),
    period_start DATE NOT NULL,
    period_end DATE NOT NULL,
    amount NUMERIC(10,2) NOT NULL
);



CREATE TRIGGER atualiza_valor_despesa_pai_ins
AFTER INSERT ON Despesa
FOR EACH ROW
BEGIN
    IF NEW.despesa_pai_id IS NOT NULL THEN
        UPDATE Despesa
        SET valor_total = (
            SELECT IFNULL(SUM(valor_total), 0)
            FROM Despesa
            WHERE despesa_pai_id = NEW.despesa_pai_id
        )
        WHERE id = NEW.despesa_pai_id;
    END IF;
END;

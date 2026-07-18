-- Fix target_roles values: Hibernate previously stored enum ordinals (0,1,2...) instead of names
-- because @Enumerated(EnumType.STRING) was missing. Convert ordinals back to enum names.

-- TargetRole enum ordinals:
-- 0 = SDE
-- 1 = FULL_STACK
-- 2 = WEB_DEVELOPER
-- 3 = AI_ML
-- 4 = DEVOPS

UPDATE roadmaps SET target_roles = (
    SELECT array_agg(
        CASE elem
            WHEN '0' THEN 'SDE'
            WHEN '1' THEN 'FULL_STACK'
            WHEN '2' THEN 'WEB_DEVELOPER'
            WHEN '3' THEN 'AI_ML'
            WHEN '4' THEN 'DEVOPS'
            ELSE elem  -- keep as-is if already a valid name
        END
    )
    FROM unnest(target_roles) AS elem
)
WHERE EXISTS (
    SELECT 1 FROM unnest(target_roles) AS elem
    WHERE elem IN ('0', '1', '2', '3', '4')
);

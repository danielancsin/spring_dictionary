USE `dictionary`;

#DROP TABLE IF EXISTS `gender_german`;

INSERT INTO `dictionary`.`gender_german` (`id`, `created_datetime`, `modified_datetime`, `created_by`, `modified_by`, `gender`)
VALUES
(1, now(), null, "admin", null, "der"),
(2, now(), null, "admin", null, "die"),
(3, now(), null, "admin", null, "das")
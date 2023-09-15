INSERT INTO public.coworking
    (id, address)
VALUES (1, 'Moscow') ON CONFLICT (id) DO NOTHING;
INSERT INTO public.coworking
    (id, address)
VALUES (2, 'Saint-Petersburg') ON CONFLICT (id) DO NOTHING;
INSERT INTO public.coworking
    (id, address)
VALUES (3, 'Kazan') ON CONFLICT (id) DO NOTHING;

INSERT INTO public.room
    (id, number_of_seats, coworking_id)
VALUES (2, 2, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.room
    (id, number_of_seats, coworking_id)
VALUES (52, 5, 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.room
    (id, number_of_seats, coworking_id)
VALUES (102, 7, 3) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.room
    (id, number_of_seats, coworking_id)
VALUES (152, 12, 3) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.room
    (id, number_of_seats, coworking_id)
VALUES (153, 13, 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.room
    (id, number_of_seats, coworking_id)
VALUES (154, 15, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.room
    (id, number_of_seats, coworking_id)
VALUES (252, 20, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.room
    (id, number_of_seats, coworking_id)
VALUES (253, 10, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO public.room
    (id, number_of_seats, coworking_id)
VALUES (254, 5, 1) ON CONFLICT (id) DO NOTHING;


INSERT INTO public.booking
    (id, room_id, end_time, start_time)
VALUES (1, 252, '2023-09-15 07:30:00.000', '2023-09-15 07:00:00.000') ON CONFLICT (id) DO NOTHING;
INSERT INTO public.booking
    (id, room_id, end_time, start_time)
VALUES (2, 252, '2023-09-15 08:30:00.000', '2023-09-15 07:30:00.000') ON CONFLICT (id) DO NOTHING;
INSERT INTO public.booking
    (id, room_id, end_time, start_time)
VALUES (152,  252, '2023-09-15 10:30:00.000', '2023-09-15 09:30:00.000') ON CONFLICT (id) DO NOTHING;
INSERT INTO public.booking
    (id, room_id, end_time, start_time)
VALUES (202, 252, '2023-09-15 11:30:00.000', '2023-09-15 10:30:00.000') ON CONFLICT (id) DO NOTHING;
INSERT INTO public.booking
    (id, room_id, end_time, start_time)
VALUES (203, 252, '2023-09-15 12:30:00.000', '2023-09-15 12:30:00.000') ON CONFLICT (id) DO NOTHING;

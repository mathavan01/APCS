import pygame
import sys
import time

WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
win_width = 970
win_height = 520


class Game:
    def __init__(self, caption):
        self.play = True
        self.intro = True
        self.outro = False
        self.pl_up = False
        self.pl_down = False
        self.pr_up = False
        self.pr_down = False
        self.caption = pygame.display.set_caption(str(caption))
        self.screen = pygame.display.set_mode((win_width, win_height))
        self.left_score = Text(90, "0", win_width / 4, win_height / 10)
        self.right_score = Text(90, "0", ((win_width / 4) * 3), win_height / 10)
        self.title = Text(150, "Pong", win_width / 2 - 300, win_height / 2 - 200)
        self.click_here = Text(90, "-- Click Here --", win_width / 2 - 300, win_height / 2 + 100)
        self.outro_text = Text(150, "Great Match", win_width/2 - 300, win_height/2 - 200)
        self.restart_game = Text(90, "-- Click To Restart --", win_width / 2 - 300, win_height / 2 +100)
        self.out_of_bounds = pygame.mixer.Sound("sound/loselife.ogg")
        self.right_win = Text(90, "Right Paddle Wins", win_width / 2 - 250, win_height / 2 + 150)
        self.left_win = Text(90, "Left Paddle Wins", win_width / 2 - 250, win_height / 2 + 150)

    def update(self, lp, rp, font, lscore, rscore, ball):
        # increment score
        if ball.rect.left > win_width:
            lp.score += 1
            time.sleep(1)
            ball.rect.centerx = win_width/2
            ball.rect.centery = win_height/2
            self.out_of_bounds.play(1)
            lp.rect.y = win_height / 2 - lp.height / 2
            rp.rect.y = win_height / 2 - rp.height / 2
            time.sleep(1)
        if ball.rect.right < 0:
            rp.score += 1
            time.sleep(1)
            ball.rect.centerx = win_width / 2
            ball.rect.centery = win_height / 2
            self.out_of_bounds.play(1)
            lp.rect.y = win_height / 2 - lp.height / 2
            rp.rect.y = win_height / 2 - rp.height / 2
            time.sleep(1)

        if ball.rect.left > win_height:
            lscore.image = font.render(str(lp.score), True, WHITE)
        if ball.rect.right > 0:
            rscore.image = font.render(str(rp.score), True, WHITE)

        if lp.score == 3 or rp.score == 3:
            self.play = False
            self.outro = True

    def blink(self):
        if pygame.time.get_ticks() % 1000 < 500:
            return True
        else:
            return False


class Text:
    def __init__(self, size, text, xpos, ypos):
        self.font = pygame.font.SysFont("Britannic Bold", size)
        self.image = self.font.render(text, True, WHITE)
        self.rect = self.image.get_rect()
        self.rect = self.rect.move(xpos, ypos)


class Paddle:
    def __init__(self, width, height, speed, xpos):
        self.width = width
        self.height = height
        self.speed = speed
        self.image = pygame.image.load("images/paddle.png").convert_alpha()
        self.image = pygame.transform.scale(self.image, (self.width, self.height))
        self.rect = pygame.Rect(xpos, height / 2 - self.height / 2, self.width, self.height)
        self.score = 0

    def update(self, up, down):
        if up or down:
            if up:
                self.rect.y -= self.speed
            if down:
                self.rect.y += self.speed

            if self.rect.y < 0:
                self.rect.y = 0
            if self.rect.bottom > win_height:
                self.rect.bottom = win_height


class Ball:
    def __init__(self, width, height, speed):
        self.width = width
        self.height = height
        self.speed = speed
        self.image = pygame.image.load("images/ball.png").convert_alpha()
        self.image = pygame.transform.scale(self.image, (self.width, self.height))
        self.rect = pygame.Rect(win_width / 2 - (self.width / 2), win_height / 2 - (self.height / 2), self.width, self.height)
        self.paddle_bounce = pygame.mixer.Sound("sound/beep1.ogg")

    def update(self, lp, rp):
        if self.rect.top < 0 or self.rect.top > win_height - self.rect.height:
            self.speed = (self.speed[0], -self.speed[1])

        # Bounce off right paddle
        if self.rect.right >= rp.rect.left + 5 and self.rect.left <= rp.rect.left - 5 and self.rect.bottom > rp.rect.top and self.rect.top < rp.rect.bottom + rp.height:
            self.speed = (-self.speed[0], self.speed[1])
            self.paddle_bounce.play(1)

        # Bounce off left paddle
        if self.rect.left <= lp.rect.right - 5 and self.rect.right >= lp.rect.right + 5 and self.rect.bottom > lp.rect.top and self.rect.top < lp.rect.bottom + lp.height:
            self.speed = (-self.speed[0], self.speed[1])
            self.paddle_bounce.play(1)

        self.rect = self.rect.move(self.speed)


def main():
    pygame.init()

    p_width = 40
    p_height = 150
    p_speed = 5

    run = Game("Pong")

    left_paddle = Paddle(p_width, p_height, p_speed, win_width/20)
    right_paddle = Paddle(p_width, p_height, p_speed, win_width - win_width/20 - p_width)

    ball = Ball(20, 20, (1, 1))

    font2 = pygame.font.SysFont("Britannic Bold", 90)

    intro_back = pygame.image.load("images/introBackground.jpg").convert()
    intro_back = pygame.transform.scale(intro_back, (win_width, win_height))
    intro_rect = intro_back.get_rect()

    background = pygame.image.load("images/background.jpg").convert()
    background = pygame.transform.scale(background, (win_width, win_height))
    background_rect = background.get_rect()

    end_back = pygame.image.load("images/end.jpg").convert()
    end_back = pygame.transform.scale(background, (win_width, win_height))
    end_rect = end_back.get_rect()

    music_intro = pygame.mixer.Sound("sound/intro.ogg")
    music_intro.play(-1)
    sound_effect_select = pygame.mixer.Sound("sound/select.ogg")

    while True:
        run.intro = run.play = True
        run.outro = False
        left_paddle.score = 0
        right_paddle.score = 0
        while run.intro:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    sys.exit()
                if event.type == pygame.MOUSEBUTTONDOWN or pygame.key.get_pressed()[pygame.K_RETURN] != 0:
                    run.intro = False
                    music_intro.stop()
                    sound_effect_select.play(1)
                run.screen.blit(intro_back, intro_rect)
                run.screen.blit(run.title.image, run.title.rect)
                if run.blink():
                    run.screen.blit(run.click_here.image, run.click_here.rect)
                pygame.display.flip()

        while run.play:
            # Keystrokes
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    sys.exit()
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_w:
                        run.pl_up = True
                        run.pl_down = False
                    if event.key == pygame.K_s:
                        run.pl_up = False
                        run.pl_down = True
                    if event.key == pygame.K_DOWN:
                        run.pr_up = False
                        run.pr_down = True
                    if event.key == pygame.K_UP:
                        run.pr_up = True
                        run.pr_down = False
                elif event.type == pygame.KEYUP:
                    if event.key == pygame.K_w:
                        run.pl_up = False
                        run.pl_down = False
                    if event.key == pygame.K_s:
                        run.pl_up = False
                        run.pl_down = False
                    if event.key == pygame.K_DOWN:
                        run.pr_up = False
                        run.pr_down = False
                    if event.key == pygame.K_UP:
                        run.pr_up = False
                        run.pr_down = False

            # Sprite Movement
            left_paddle.update(run.pl_up, run.pl_down)
            right_paddle.update(run.pr_up, run.pr_down)

            # Ball bouncing + movement
            ball.update(left_paddle, right_paddle)

            # Scoring
            run.update(left_paddle, right_paddle, font2, run.left_score, run.right_score, ball)

            # Place sprites  onto the screen
            run.screen.blit(background, background_rect)
            run.screen.blit(left_paddle.image, left_paddle.rect)
            run.screen.blit(right_paddle.image, right_paddle.rect)
            run.screen.blit(ball.image, ball.rect)
            run.screen.blit(run.left_score.image, run.left_score.rect)
            run.screen.blit(run.right_score.image, run.right_score.rect)
            pygame.display.flip()

        while run.outro:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    sys.exit()
                if event.type == pygame.MOUSEBUTTONDOWN or pygame.key.get_pressed()[pygame.K_RETURN] != 0:
                    run.outro = False
                    run.intro = run.play = True
            run.screen.blit(end_back, end_rect)
            run.screen.blit(run.outro_text.image, run.outro_text.rect)
            if left_paddle.score == 3:
                run.screen.blit(run.left_win.image, run.left_win.rect)
            if right_paddle.score == 3:
                run.screen.blit(run.right_win.image, run.right_win.rect)
            if run.blink():
                run.screen.blit(run.restart_game.image, run.restart_game.rect)
            pygame.display.flip()


if __name__ == "__main__":
    main()
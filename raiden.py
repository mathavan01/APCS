import pygame
import time
import sys
import os

os.environ['SDL_VIDEO_CENTERED'] = '1'  # Force static position of screen
# Constants
WHITE = (255, 255, 255)
GRAY = (80, 80, 80)

WIN_W = 16 * 32
WIN_H = 700
SHIP_W = SHIP_H = 14


class Platform(pygame.sprite.Sprite):
    def __init__(self, xpos, ypos):
        pygame.sprite.Sprite.__init__(self)
        self.image = pygame.Surface((32, 32))
        self.image.convert()
        self.image.fill(GRAY)
        self.rect = self.image.get_rect()
        self.rect = self.rect.move(xpos, ypos)


class Ship(pygame.sprite.Sprite):
    def __init__(self, container):
        pygame.sprite.Sprite.__init__(self)
        self.container = container
        self.speed = 5
        self.image = pygame.Surface((SHIP_W, SHIP_H)).convert()
        self.rect = self.image.get_rect()
        self.rect.centerx = self.container.centerx
        self.rect.centery = self.container.bottom - (3 * self.rect.height)

    def update(self):
        key = pygame.key.get_pressed()
        if key[pygame.K_w]:
            self.rect.y -= self.speed
        if key[pygame.K_a]:
            self.rect.x -= self.speed
        if key[pygame.K_s]:
            self.rect.y += self.speed
        if key[pygame.K_d]:
            self.rect.x += self.speed

        self.rect.clamp_ip(self.container)


def main():
    # Initialize variables
    pygame.init()
    fps = 60
    clock = pygame.time.Clock()
    play = intro = True
    container = pygame.Rect(0, 0, WIN_W, WIN_H)
    outro = False
    pygame.display.set_caption('Raiden')
    screen = pygame.display.set_mode((WIN_W, WIN_H), pygame.SRCALPHA)
    level = [
        "PPPPPPPPPPPPPPPP",
        "P              P",
        "P              P",
        "P          PPPPP",
        "P              P",
        "PPPPPPPP       P",
        "P              P",
        "P              P"
        "P              P",
        "P          PPPPP",
        "P              P",
        "P              P",
        "PPPP           P",
        "P              P",
        "P           PPPP",
        "PPPPP          P",
        "P              P",
        "P              P",
        "P        PPPPPPP",
        "P              P",
        "PPPPPP         P",
        "P              P",
        "PPPPPPPPPPPPPPPP", ]

    x = y = 0

    # Create Objects
    ship = Ship(container)

    # Create Groups
    p_group = pygame.sprite.Group()
    ship_group = pygame.sprite.Group()
    ship_group.add(ship)

    # Build The Level
    for row in level:
        for col in row:
            if col == "P":
                p = Platform(x, y)
                p_group.add(p)
            x += 32
        y += 32
        x = 0

    while intro:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                sys.exit()
            if event.type == pygame.MOUSEBUTTONDOWN or pygame.key.get_pressed()[pygame.K_RETURN] != 0:
                intro = False

            pygame.display.flip()
    while play:
        # Read Input
        # Checks if window exit button pressed
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                sys.exit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_ESCAPE:
                    pygame.quit()
                    sys.exit()

        # Run Update
        ship.update()

        # Draw Objects
        screen.fill(WHITE)
        p_group.draw(screen)
        screen.blit(ship.image, ship.rect)

        # limits frames per iteration of the while loop
        clock.tick(fps)
        # writes to main surface
        pygame.display.flip()

    while outro:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                sys.exit()

        pygame.display.flip()


if __name__ == "__main__":
    main()